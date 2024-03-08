package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/comment/list")
public class CommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 페이지를 불러옴
		int page = 1;
		int boNum = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			boNum = Integer.parseInt(request.getParameter("boNum"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		CommentCriteria cri = new CommentCriteria(page, 2, boNum);
		//현재 페이지에 맞는 댓글을 가져오라고 시킴
		ArrayList<CommentVO> list = boardService.getCommentList(cri);
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("list", list);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

}
