package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보내준 num를 가져옴
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch (Exception e){
			num = 0;
		}
		//서비스에게 게시글 번호가 num인 게시글을 가져오라고 요청
		BoardVO board = boardService.getBoard(num);
		//게시판 리스트를 가져옴
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		//화면에 게시글을 전송
		request.setAttribute("list", list);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 번호, 내용, 제목, 게시판 번호를 가져옴
		int num,co_num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
			co_num = Integer.parseInt(request.getParameter("community"));
		}catch (Exception e){
			num = 0;
			co_num = 0;
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//게시글 번호, 내용, 제목, 게시판 번호를 이용해서 게시글 객체를 생성
		BoardVO board = new BoardVO(num, title, content, co_num);
		//회원 가져옴
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//서비스에게 회원 정보와 수정할 게시글 정보를 주면서 수정하라고 요청
		boolean res = boardService.updateBoard(board, user);
		//수정했으면 게시글을 수정했습니다
		if(res) {
			request.setAttribute("msg", "게시글을 수정 했습니다.");
		}
		//못했으면 게시글을 수정하지 못했습니다라고 알림
		else {
			request.setAttribute("msg", "게시글을 수정하지 못했습니다..");
		}
		//게시글 상세로 이동
		request.setAttribute("url", "board/detail?num="+num);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
