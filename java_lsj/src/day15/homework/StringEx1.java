package day15.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StringEx1 {

	private static Scanner scan = new Scanner(System.in);
	private static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	public static void main(String[] args) {

		int menu = 0;
		//반복
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//메뉼 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != 4);
	}
	
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.단어 추가");
		System.out.println("2.뜻 추가");
		System.out.println("3.조회");
		System.out.println("4.종료");
		System.out.print("메뉴 선택 : ");
	}

	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//단어 추가
			ArrayList<String> list = new ArrayList<String>();
			System.out.print("추가할 단어 : ");
			String word = scan.next();
			if(map.containsKey(word)){
				System.out.println("이미 있는 단어");
			}else {
				map.put(word, list);
			}
			break;
		case 2:
			//뜻 추가
			System.out.print("뜻을 추가할 단어 : ");
			word = scan.next();
			if(map.containsKey(word)) {
				System.out.print("추가할 뜻 : ");
				String mean = scan.next();
				map.get(word).add(mean);
			}else {
				System.out.println("없는 단어");
			}
			break;
		case 3:
			//종료
			System.out.println(map);
			break;
		case 4:
			//종료
			System.out.println("종료");
			break;
		default:
			throw new InputMismatchException();
		}
	}

}