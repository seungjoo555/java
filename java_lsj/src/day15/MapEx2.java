package day15;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MapEx2 {
	static Scanner scan = new Scanner(System.in);
	static Map<String, String> user = new HashMap<String, String>();

	public static void main(String[] args) {
		/* 회원을 관리하는 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 회원가입
		 * 	- 아이디와 비번만 입력
		 * 	- 이미 가입된 회원인지 체크(containsKey)
		 * 2. 회원검색
		 * 	- 아이디를 입력해서 회원 정보를 조회
		 * 3. 종료
		 * 
		 */
		int menu = 0;
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//메뉴별 동작
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();//잘못 입력된 값을 문자열로 가져와서 버림
			}
		}while(menu != 3);
		
		scan.close();
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertMember();
			break;
		case 2:
			searchMember();
			break;
		case 3:
			System.out.println("종료");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private static void searchMember() {
		scan.nextLine();
		//아이디 입력
		System.out.print("아이디 :");
		String id = scan.next();
		//회원정보 조회
		if(user.containsKey(id)) {
			//있으면 보여줌
			System.out.println("아이디 : " + id + " 비번 : " + user.get(id));
		}else {
			//없으면 없다고 알림
			System.out.println("없는 아이디 입니다.");
		}
	}

	private static void insertMember() {
		scan.nextLine();
		//아이디 입력
		System.out.print("아이디 :");
		String id = scan.next();
		scan.nextLine();
		//비번 입력
		System.out.print("비밀번호 : ");
		String pwd = scan.next();
		//중복 체크
		if(user.containsKey(id)) {
			//있으면 추가 x
			System.out.println("이미 있는 아이디");
		}else {
			//없으면 추가함
			user.put(id, pwd);
		}
	}

	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 검색");
		System.out.println("3. 종료");
		System.out.println("-------------");
		System.out.print("메뉴선택 : ");
	}

}
