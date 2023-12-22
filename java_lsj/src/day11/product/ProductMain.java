package day11.product;

import java.util.Scanner;

public class ProductMain {
	private static Scanner scan = new Scanner(System.in);
	private static Product[] list = new Product[5];	//제품을 저장할 배열
	private static int count = 0;	//저장된 제품목록의 개수
	
	/* 제품을 관리하는 프로그램 구현하세요.
	 * 
	 * 메뉴
	 * 1. 제품 입고
	 * 	- 제품을 판매하기 위해 다른 곳에서 제품을 구매
	 * 2. 제품 판매
	 * 	- 입고된 제품을 판매
	 * 3. 제품 목록(제품이름 재고개수 판매가격)
	 * 	- 1. 제품 수정[가격]
	 * 	- 2. 뒤로가기
	 * 4. 매출 내역 조회
	 * 	- 일자별 조회
	 * 5. 종료
	 * 
	 * 제품을 저장할 배열 생성(배열이 다 차면 늘려주는 메서드 추가할것)
	 * 
	 * 제품의 이름, 개수, 판매할 가격을 정해서 입고
	 * 
	 * 제품을 검색하고 판매 개수 입력하기
	 * 제품 몇개가 총 얼마에 팔렸다고 알려주기
	 * 제품의 총판매개수 총판매금액에 추가
	 * 
	 * 제품의 이름을 찾아서 제품의 가격 수정
	 * 
	 * 매출 내역은 제품이름 총판매개수 총판매금액
	 * 제일밑에 총 매출금액
	 * 
	 */
	public static void main(String[] args) {
		int menu;
		//반복문
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴에 맞는 기능 실행
			runMenu(menu);
		}while(menu != 5);
	}

	private static void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 목록");
		System.out.println("4. 매출 내역 조회");
		System.out.println("5. 종료");
		System.out.println("--------------");
		System.out.print("메뉴 선택 : ");
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//제품 입고
			insertProduct();
			break;
		case 2:
			//제품 판매
			saleProduct();
			break;
		case 3:
			//제품 목록 - 가격수정 서브메뉴
			printProductList();
			break;
		case 4:
			//매출 내역 조회
			salesHistory();
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("메뉴 선택을 다시 하세요.");
			
		}
	}

	private static void insertProduct() {
		//입고할 제품의 이름, 개수, 판매가격 설정
		scan.nextLine();	//엔터처리
		System.out.print("제품 이름 : ");
		String name = scan.next();
		//반복문 : 제품 목록 전체
		for(int i = 0; i < count; i++) {
			//입력한 제품 이름과 같은 제품이 있다면
			if(list[i].equals(name)) {
				System.out.print("입고 개수 : ");
				int num = scan.nextInt();
				//해당 제품의 개수를 추가하고 종료
				list[i].setCount(list[i].getCount() + num);
				return;	//일치하는 게시물이 있다면 끝내고 없다면 밑에 프린트문구를 실행하기 위해
			}
		}
		System.out.print("입고 개수 : ");
		int num = scan.nextInt();
		System.out.print("판매 가격 : ");
		int price = scan.nextInt();
		
		Product tmp = new Product(name, num, price);
		list[count] = tmp;
		count++;
		if(count == list.length) {
			expandProductList();
		}
	}
	
	private static void expandProductList() {
		//기존 단어장보다 큰 새 단어장 생성
		Product [] tmpList = new Product[list.length + 5];
		//새 단어장에 기존 단어들을 복붙
		System.arraycopy(list, 0, tmpList, 0, count);
		//새 단어장을 내 단어장이라고 선언
		list = tmpList;
	}
	
	private static void saleProduct() {
		//검색할 제품, 개수 입력
		scan.nextLine();	//엔터처리
		System.out.print("판매할 제품 : ");
		String name = scan.next();
		System.out.print("판매할 개수 : ");
		int num = scan.nextInt();
		
		//제품 목록에서 검색해서 판매
		//반복문 : 저장된 개수만큼
		for(int i = 0; i < count; i++) {
			//제품목록에 선택한 제품이 있으면
			if(list[i].equals(name)) {
				//판매개수를 재고개수보다 많이 적었을 경우
				if(list[i].getCount() < num) {
					num = list[i].getCount();
				}
				list[i].setCount(list[i].getCount() - num);
				list[i].setS_count(list[i].getS_count() + num);
				list[i].setTotalprice((list[i].getPrice() * num));
				return;
			}
		}
		//제품이 없다고 출력
		System.out.println("일치하는 제품이 없습니다.");
	}
	
	private static void printProductList() {
		int submenu;
		//제품 목록을 출력하고 서브메뉴를 추가
		do {
			System.out.println("------- 제품 목록 ---------");
			for(int i = 0; i < count; i++) {
				list[i].printInfo();
			}
			System.out.println("------------------------");
			//서브메뉴를 출력
			printSubmenu();
			//서브메뉴 선택
			submenu = scan.nextInt();
			//서브메뉴 맞는 기능 실행
			runSubmenu(submenu);
		}while(submenu != 2);
	}
	
	private static void printSubmenu() {
		System.out.println("1. 제품 수정[가격]");
		System.out.println("2. 뒤로가기");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 :");
	}
	
	private static void runSubmenu(int submenu) {
		switch(submenu) {
		case 1:
			//제품 가격 수정하기
			updateProduct();
			break;
		case 2:
			//뒤로가기
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			System.out.println();
		}
	}
	
	private static void updateProduct() {
		//수정할 제품의 이름을 입력
		scan.nextLine();	//엔터처리
		System.out.print("수정할 제품의 이름 : ");
		String name = scan.next();
		//반복문 : 제품 목록 전체
		for(int i = 0; i < count; i++) {
			//입력한 제품 이름과 같은 제품이 있다면
			if(list[i].equals(name)) {
				System.out.print("수정할 가격 : ");
				int price = scan.nextInt();
				//해당 제품의 가격을 수정하고 종료
				list[i].update(price);
				return;	//일치하는 게시물이 있다면 끝내고 없다면 밑에 프린트문구를 실행하기 위해
			}
		}
		//일치하는 제품이 없다고 출력
		System.out.println("일치하는 제품이 없습니다.");
	}
	
	private static void salesHistory() {
		int sumprice = 0;
		System.out.println("----------------------------------------------------------------");
		System.out.println("제품 이름			판매개수			총판매금액");
		for(int i = 0; i < count; i++) {
			sumprice += list[i].getTotalprice();
			list[i].printSales();
		}
		System.out.println();
		System.out.println("총 매출 금액 : " + sumprice);
		System.out.println("----------------------------------------------------------------");
	}
	
}
