package community.main;

import java.util.Scanner;

import community.controller.CommunityController;

public class Main {

	private static CommunityController communityController;
	public static void main(String[] args) {
		int menu;
		Scanner scan = new Scanner(System.in);
		communityController = new CommunityController(scan);
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu != 3);

	}
	private static void printMenu() {
		System.out.println("킹스맨 카페");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			communityController.rogIn();
			break;
		case 2:
			communityController.signUp();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

}
