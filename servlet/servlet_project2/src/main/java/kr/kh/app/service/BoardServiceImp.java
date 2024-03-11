package kr.kh.app.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.utils.FileUploadUtils;

public class BoardServiceImp implements BoardService {

	private BoardDAO boardDao;
	private String uploadPath = "D:\\uploads";
	
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		//현재 페이지정보 null 처리 
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public boolean insertBoard(BoardVO board, ArrayList<Part> partList) {
		if( board == null || 
			!checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		if(!checkString(board.getBo_me_id())) {
			return false;
		}
		boolean res = boardDao.insertBoard(board);
		//게시글 등록에 실패한 경우
		if(!res) {
			return false;
		}
		//첨부파일이 없는 경우
		if(partList == null || partList.size() == 0) {
			return true;
		}
		
		for(Part filePart : partList) {
			uploadFile(filePart, board.getBo_num());
		}
		
		return res;
	}
	
	//문자열이 null이거나 빈 문자열이면 false, 아니면 true를 반환하는 메서드
	public boolean checkString(String str) {
		if(str == null || str.length() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectTotalCount(cri);
	}

	@Override
	public boolean updateView(int num) {
		return boardDao.updateView(num);
	}

	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}

	@Override
	public boolean deleteBoard(int num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//게시글을 가져옴
		BoardVO board = boardDao.selectBoard(num);
		//게시글이 없거나 작성자가 아니면 false를 리턴
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		ArrayList<FileVO> fileList = boardDao.selectFileList(num);
		for(FileVO file : fileList) {
			deleteFile(file);
		}
		
		//게시글을 삭제 요청
		return boardDao.deleteBoard(num);
	}

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user, String[] nums, ArrayList<Part> fileList) {
		//게시글 null체크
		if( board == null || 
			!checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		//회원 null 체크
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		//게시글 번호를 이용하여 게시글을 가져옴
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		//게시글이 없거나 게시글 작성자가 회원이 아니면 false를 리턴
		if(dbBoard == null ||
			!dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		
		//첨부파일 삭제
		if(nums != null) {
			for(String numStr : nums) {
				try {
					int num = Integer.parseInt(numStr);
					FileVO fileVo = boardDao.selectFile(num);
					deleteFile(fileVo);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		//첨부파일 추가
		for(Part file : fileList) {
			uploadFile(file, board.getBo_num());
		}
		
		//서비스에게 게시글을 주면서 수정하라고 요청
		return boardDao.updateBoard(board);
	}
	
	@Override
	public ArrayList<FileVO> getFileList(int num) {
		return boardDao.selectFileList(num);
	}
	
	private void uploadFile(Part filePart, int bo_num) {
		if(filePart == null || bo_num == 0) {
			return;
		}
		String fileOriName = FileUploadUtils.getFileName(filePart);
		if(fileOriName == null || fileOriName.length() == 0) {
			return;
		}
		String fileName = FileUploadUtils.upload(uploadPath,  filePart);
		FileVO file = new FileVO(bo_num, fileName, fileOriName);
		boardDao.insertFile(file);
	}

	private void deleteFile(FileVO fileVo) {
		if(fileVo == null) {
			return;
		}
		File file = new File(uploadPath 
				+ fileVo.getFi_name().replace('/', File.separatorChar));
		if(file.exists()) {
			file.delete();
		}
		boardDao.deleteFile(fileVo.getFi_num());
	}

	@Override
	public int recommend(int boNum, int state, String me_id) {
		switch(state) {
		case -1, 1: break;
		default:
			throw new RuntimeException();
		}
		//회원이 게시글에 추천한 내역이 있는지 확인 => 없으면 추가, 있으면 수정
		//회원이 게시글에 추천한 정보를 가져옴
		RecommendVO recommend = boardDao.selectRecommend(boNum, me_id);
		//없으면 추가
		if(recommend == null) {
			recommend = new RecommendVO(me_id, boNum, state);
			boardDao.insertRecommend(recommend);
			return state;
		}
		//있으면 수정
		//이전 추천 상태와 현재 추천 상태가 같다 => 취소
		if(state == recommend.getRe_state()) {
			recommend.setRe_state(0);
		}
		//변경. 추천->비추천, 비추천->추천
		else {
			recommend.setRe_state(state);
		}
		boardDao.updateRecommend(recommend);
		return recommend.getRe_state();
	}

	@Override
	public RecommendVO getRecommend(int num, MemberVO user) {
		if(user == null || num <= 0) {
			return null;
		}
		return boardDao.selectRecommend(num,  user.getMe_id());
	}

	@Override
	public ArrayList<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return boardDao.selectCommentList(cri);
	}

	@Override
	public int getTotalCommentCount(Criteria cri) {
		if(cri == null) {
			return 0;
		}
		return boardDao.selectTotalCommentCount(cri);
	}
	
	
}