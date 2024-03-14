package kr.kh.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.community.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("/regist")
	public void regist() {
		
	}
	
	@RequestMapping("/list")
	public void list() {
		
	}
	
	@RequestMapping("/update")
	public void update() {
		
	}
	
	@RequestMapping("/delete")
	public void delete() {
		
	}
}
