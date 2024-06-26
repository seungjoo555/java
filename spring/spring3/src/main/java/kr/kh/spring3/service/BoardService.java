package kr.kh.spring3.service;

import java.util.ArrayList;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

	boolean insertBoard(BoardVO board, MemberVO user);

	ArrayList<CommunityVO> getCommunityList();

	void updateView(int num);

	BoardVO getBoard(int num);

	ArrayList<FileVO> getFileList(int num);
	
}
