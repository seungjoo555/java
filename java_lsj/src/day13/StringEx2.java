package day13;

import java.util.Scanner;

public class StringEx2 {
	private static Scanner scan = new Scanner(System.in);
	private static String []str = new String[5];
	private static int count = 0;
	/* 문장들을 입력받아 배열에 저장하고, 특정 단어가 들어가 있는 문장들을
	 * 출력하는 프로그램을 작성하세요.
	 * 메뉴
	 * 1. 문장 추가
	 * 2. 검색
	 * 3. 종료
	 */
	
	/* 안녕하세요.
	 * 테스트
	 * 만나서 반갑습니다.
	 * 나는 홍길동입니다.
	 * 
	 * 나로 검색
	 * 
	 * 만나서 반갑습니다.
	 * 나는 홍길동입니다.
	 * 
	 */
	public static void main(String[] args) {
		
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu != 3);
	}
	
	private static void printMenu() {
		System.out.println("-------- 메뉴 --------");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//문장추가
			insertStr();
			break;
		case 2:
			//검색
			searchStr();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private static void searchStr() {
		scan.nextLine();
		System.out.print("검색 : ");
		String str1 = scan.next();
		for(String tmp : str) {
			if(tmp != null && tmp.contains(str1)) {
				System.out.println(tmp);
			}
		}
	}

	private static void insertStr() {
		System.out.print("문장 추가 : ");
		scan.nextLine();	//입력 버퍼에 남아있는 엔터 처리
		String str1 = scan.nextLine();
		System.out.println("--------------------");
		str[count++] = str1;
		if(count < str.length) {
			return;
		}
		str = expandList(str);
	}
	
	public static String[] expandList(String[] str) {
		String [] tmpList = new String[str.length + 5];
		System.arraycopy(str, 0, tmpList, 0, str.length);
		return tmpList;
	}
}
