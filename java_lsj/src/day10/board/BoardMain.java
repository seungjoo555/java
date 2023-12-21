package day10.board;

import java.util.Scanner;

public class BoardMain {
	private static Scanner scan = new Scanner(System.in);
	private static Board []boardList = new Board[10];	//게시글 목록
	private static int count = 0;		//현재 등록된 게시글 개수
	/* 게시판에서 게시글 관리를 위한 콘솔 프로그램 작성하세요.
	 * - 제한사항 정리
	 * 	-게시글 작성시 작성자(ID)입력
	 * 	-게시글 조회
	 * 	-게시글 작성
	 * 	-게시글 수정/삭제
	 * 
	 * 1. 필요한 기능을 정리해서 메뉴로 출력
	 * ----- 게시글 목록 -----
	 * 3. 메밀꽃 필 무렵 2023-12-20 ID: kor 조회: 1
	 * 2. 내가 첫번째 2023-12-20 ID: first 조회: 2
	 * 1. 공지 2023-12-20 ID: admin 조회: 5
	 * 
	 * ----- 게시판 메뉴 -----
	 * 1. 게시글 작성
	 * 2. 게시글 수정
	 * 3. 게시글 삭제
	 * 4. 프로그램 종료
	 * 메뉴 선택 : 1
	 * 
	 * ----- 게시글 목록 -----
	 * 3. 메밀꽃 필 무렵 2023-12-20 ID: kor 조회: 1
	 * 2. 내가 첫번째 2023-12-20 ID: first 조회: 2
	 * 1. 공지 2023-12-20 ID: admin 조회: 5
	 * 
	 * ----- 게시판 메뉴 -----
	 * 1. 게시글 작성
	 * 2. 게시글 수정
	 * 3. 게시글 삭제
	 * 4. 프로그램 종료
	 * 메뉴 선택 : 1
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 2. 기능을 구현
	 * 
	 */
	public static void main(String[] args) {
		//반복문
		int menu;
		do {
			//게시글 출력
			printBoard();
			//메뉴출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 기능 실행
			runMenu(menu);
		}while(menu != 5);
	}
	
	private static void printBoard() {
		//게시글 목록을 출력. 번호가 높은 순으로
		System.out.println("-------게시글 목록-------");
		for(int i = count; i > 0; i--) {
			boardList[i-1].printInfo();
		}
		System.out.println("----------------------");
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//게시글 작성
			insertBoard();
			break;
		case 2:
			//게시글 수정
			updateBoard();
			break;
		case 3:
			//게시글 삭제
			deleteBoard();
			break;
		case 4:
			//게시글 상새내용
			printBoardDetail();
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	private static void printBoardDetail() {
		//조회할 게시글 번호를 입력
		System.out.print("조회할 게시글 번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		//반복문 : 등록된 게시글 전체, 배열 전체 x
		for(int i = 0; i < count; i++) {
			//입력한 번호와 같은 번호를 가진 게시글 찾고
			if(num == boardList[i].getNum()) {
				//해당 게시글의 printInfoDetail 을 호출
				boardList[i].printInfoDetail();
				return;	//일치하는 게시물이 있다면 끝내고 없다면 밑에 프린트문구를 실행하기 위해
			}
		}
		System.out.println("일치하는 게시글이 없습니다.");
	}

	private static void deleteBoard() {
		//삭제할 게시글 번호를 입력
		System.out.print("삭제할 게시글 번호 : ");
		int num = scan.nextInt();
		//반복문 : 게시글 목록 전체
		int index = -1; // 일치하는 게시글이 있는 번지
		for(int i = 0; i < count; i++) {
			//입력한 번호와 일치하는 게시글을 찾아 번지를 저장
			if(num == boardList[i].getNum()) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("일치하는 게시글이 없습니다.");
			return;
		}
		count--;
		//가장 최근에 등록된 게시글을 삭제했다면
		//== 배열에서 가장 마지막에 있는 게시글을 삭제했다면
		if(index == count) {
			return;
		}
		//찾은 번지 다음부터 한칸씩 당겨옴
		//기존 배열과 크기가 같은 새 배열을 생성
		Board []tmpList = new Board[boardList.length];
		//새 배열에 기존 배열을 복사
		System.arraycopy(boardList, 0, tmpList, 0, boardList.length);
		//기존 배열에서 찾은 번지 다음부터 나머지 개수를 복사해서
		//새 배열에 찾은 번지부터 덮어씀
		System.arraycopy(tmpList, index+1, boardList, index, count - index);
		//게시글의 번호 재설정
		for(int i = index; i < count; i++) {
			boardList[i].setNum(boardList[i].getNum() - 1);
		}
	}

	private static void updateBoard() {
		//수정할 게시글 번호와 제목, 내용을 입력
		System.out.print("수정할 게시글 번호 : ");
		int num = scan.nextInt();
		//반복문 : 게시글 목록 전체
		for(int i = 0; i < count; i++) {
			//입력한 게시글 번호와 일치하는 게시글이 있으면
			if(num == boardList[i].getNum()) {
				scan.nextLine();
				System.out.print("제목 수정 : ");
				String title = scan.nextLine();
				System.out.print("내용 수정 : ");
				String contents = scan.nextLine();
				//해당 게시글의 제목과 내용을 수정하고 메서드 종료
				boardList[i].update(title, contents);
				return;	//일치하는 게시물이 있다면 끝내고 없다면 밑에 프린트문구를 실행하기 위해
			}
		}
		//일치하는 게시글이 없습니다라고 출력
		System.out.println("일치하는 게시글이 없습니다.");
	}

	private static void printMenu() {		// TODO Auto-generated method stub
		System.out.println("-------- 메뉴 --------");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 상세내용");
		System.out.println("5. 프로그램 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}
	
	private static void insertBoard() {
		scan.nextLine();	//입력 버퍼에 남아있는 엔터 처리
		//제목, 내용, 일자, 아이디 순으로 입력받음
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		System.out.print("일자 : ");
		String date = scan.next();
		System.out.print("작성자: ");
		String writer = scan.next();
		//입력받은 정보들을 이용하여 게시글 인스턴스를 생성
		Board board = new Board(title, contents, writer, date);
		//생성된 인스턴스를 배열에 저장(몇번지)
		boardList[count++] = board;
		//배열 크기를 안늘려도 되면 종료
		if(count < boardList.length) {
			return;
		}
		//배열이 꽉 차면 배열을 늘려줌
		//기존 배열보다 큰 배열 생성
		Board[] tmpList = new Board[boardList.length + 5];
		//새로 생성된 배열에 기존 배열을 복사
		System.arraycopy(boardList, 0, tmpList, 0, count);
		//새로 생성된 배열을 boardList 연결
		boardList = tmpList;
	}
}
