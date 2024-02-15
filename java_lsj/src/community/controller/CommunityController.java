package community.controller;

import java.util.Scanner;
import java.util.regex.Pattern;

import community.model.vo.Member;
import community.service.UserService;
import community.service.UserServiceImp;

public class CommunityController {
	
	private static Member user;
	private Scanner scan;
	private UserService userService;
	
	public CommunityController(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		userService = new UserServiceImp();
	}
	
	public void rogIn() {
		//로그인체크
		System.out.print("아이디 : ");
		String id = scan.next();
		if(!userService.checkId(id)) {
			System.out.println("없는아이디입니다. 회원가입을 해주세요");
			return;
		}
		System.out.print("비밀번호 : ");
		String pwd = scan.next();
		if(!userService.checkPwd(pwd)) {
			System.out.println("비밀번호가 틀렸습니다. 다시 로그인 해주세요.");
			return;
		}
		//user - 데이터베이스에서 정보 가져오기 
		user = userService.getMember(id, pwd);
		//관리자메뉴 (사용자관리 - 정보수정x, 이용정지, 탈퇴기능, 가입승인) - 데이터베이스에 사용자상태 추가
		//1.사용자관리, 2.게시판관리(카테고리,게시판), 3.게시글관리, 4.댓글관리, 5.로그아웃
		
		//사용자메뉴 (내정보관리 - 수정, 탈퇴)
		//1.내정보관리, 2.카페이용(게시글, 댓글), 3.로그아웃
				
	}
	
	public void signUp() {
		System.out.println("회원가입 절차 시작");
		String idRegex = "^[a-zA-Z0-9_]{6,12}$";
		String pwdRegex = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
		String emailRegex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		String id,pwd,pwd2,email,name,phone,addr;
		do {
			System.out.print("아이디(영문,숫자 6~12자리) : ");
			id = scan.next();
			if(Pattern.matches(idRegex, id)) {
				System.out.println("아이디로 사용 가능합니다.");
				break;
			}else {
				System.out.println("아이디 형식에 맞지 않습니다.");
				continue;
			}
		}while(true);
		do {
			System.out.print("비밀번호(영문,숫자,특수문자 8~15자리) : ");
			pwd = scan.next();
			System.out.print("비밀번호 확인 : ");
			pwd2 = scan.next();
			if(!pwd.equals(pwd2)) {
				System.out.println("비밀번호와 확인부분이 다릅니다. 다시 입력 해주세요.");
				continue;
			}
			if(Pattern.matches(pwdRegex, pwd)) {
				System.out.println("비밀번호로 사용 가능합니다.");
				break;
			}else {
				System.out.println("비밀번호 형식에 맞지 않습니다.");
				continue;
			}
		}while(true);
		do {
			System.out.print("이메일 : ");
			email = scan.next();
			if(Pattern.matches(emailRegex, email)) {
				System.out.println("이메일로 사용 가능합니다.");
				break;
			}else {
				System.out.println("이메일 형식에 맞지 않습니다.");
				continue;
			}
		}while(true);
		do {
			System.out.print("이름 : ");
			name = scan.next();
			if(name.length() < 2 || name.length() > 30) {
				System.out.println("이름은 2자이상 30자이하 입니다.");
				continue;
			}else {
				break;
			}
		}while(true);
		System.out.print("전화번호 : ");
		phone = scan.next();
		
		System.out.print("주소(oo시 oo구 oo동) : ");
		scan.nextLine();
		addr = scan.nextLine();
		
		Member member = new Member(id, pwd, email, name, phone, addr);
		if(userService.insertMember(member)) {
			System.out.println("내역을 추가했습니다.");
		}else {
			System.out.println("내역을 추가하지 못했습니다.");
		}
	}
	
}
