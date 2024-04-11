package kr.kh.spring3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring3.model.dto.LoginDTO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("안녕하세요. 스프링 메인입니다.");
		model.addAttribute("title","메인 페이지");
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		log.info("안녕? 여긴 회원가입");
		model.addAttribute("title","회원가입");
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {
		log.info("들어온 정보 \n" + member);
		boolean res = memberService.insertMember(member);
		if(res) {
			model.addAttribute("msg", "회원가입 했다");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "가입 못했다");
			model.addAttribute("url", "/signup");
		}
		return "message";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title","로그인 페이지");
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, LoginDTO loginDto) {
		log.info("들어온 정보 \n" + loginDto);
		MemberVO user = memberService.getMember(loginDto);
		model.addAttribute("user", user);
		if(user != null) {
			model.addAttribute("msg", "로그인 했다");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "로그인 못했다");
			model.addAttribute("url", "/login");
		}
		return "message";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("user");
		model.addAttribute("msg", "로그아웃 했다");
		model.addAttribute("url", "/");
		return "message";
	}
	
	@GetMapping("/sse")
	public String sse() {
		
		return "/ex/sse";
	}
	
}
