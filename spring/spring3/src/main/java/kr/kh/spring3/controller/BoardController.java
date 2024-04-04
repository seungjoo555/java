package kr.kh.spring3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/post/list")
	public String postList(Model model, Criteria cri) {
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		model.addAttribute("title", "게시글 목록");
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/post/list";
	}
	
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		model.addAttribute("title", "글쓰기");
		return "/post/insert";
	}
	
	@PostMapping("/post/insert")
	public String postInsertPost(Model model, BoardVO board, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.insertBoard(board, user);
		if(res) {
			model.addAttribute("msg", "게시글을 등록했다.");
			model.addAttribute("url", "/post/list");
		}else {
			model.addAttribute("msg", "게시글을 등록못했다.");
			model.addAttribute("url", "/post/insert");
		}
		return "message";
	}
	
	
	
	
	@ResponseBody
	@GetMapping("/api/post/list")
	public Map<String, Object> apiPostList(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<BoardVO> list = boardService.getBoardList(new Criteria());
		map.put("list", list);
		return map;
	}
}
