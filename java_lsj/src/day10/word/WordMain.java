package day10.word;

import java.util.Scanner;

public class WordMain {
	private static Scanner scan = new Scanner(System.in);
	private static Word []wordList = new Word[10];	//단어장 목록
	private static int count = 0;		//현재 등록된 단어의 개수
	/* 영어 단어장 프로그램을 만드세요.
	 * 1. 기능 정리
	 * 	-단어장에 들어있는 전체 목록 보여주는 메뉴
	 * 	-단어장에 n개의 단어를 저장(영단어, 한글뜻)
	 * 	-잘못쓴 단어 삭제하기
	 * 	-무작위 순서로 한글이 나오고 그에 맞는 영단어를 쓰기
	 * 	-전체 문제/맞춘 개수 나오기
	 * 	-다 맞추면 새로운 단어로 교체하라고 알려주기
	 * 
	 * 2. 틀니 작성
	 * 
	 * 메뉴
	 * 1. 단어장 목록
	 * 2. 테스트 하기
	 * 3. 종료하기
	 * 메뉴 선택 : 1
	 * 
	 * ------------------------------------------------
	 * 
	 * ------- 단어장 목록 ---------
	 * 1. chair 의자
	 * 2. make 만들다
	 * 3. morning 아침
	 * --------------------------
	 * 1. 단어 저장하기
	 * 2. 단어 수정하기
	 * 3. 단어 삭제하기
	 * 4. 뒤로가기
	 * 메뉴 선택 : 1
	 * 
	 * ------------------------------------------------
	 * 
	 * 단어 저장하기
	 * 영단어 : apple
	 * 한글 : 사과
	 * 
	 * -------------------------------------------
	 * 
	 * ------- 단어장 목록 ---------
	 * 1. chair 의자
	 * 2. make 만들다
	 * 3. morning 아침
	 * 4. apple 사과
	 * --------------------------
	 * 1. 단어 저장하기
	 * 2. 단어 수정하기
	 * 3. 단어 삭제하기
	 * 4. 뒤로가기
	 * 메뉴 선택 : 2
	 * 삭제할 단어의 번호 : 4
	 * 
	 * -------------------------------------------
	 * 
	 * ------- 단어장 목록 ---------
	 * 1. chair 의자
	 * 2. make 만들다
	 * 3. morning 아침
	 * --------------------------
	 * 1. 단어 저장하기
	 * 2. 단어 수정하기
	 * 3. 단어 삭제하기
	 * 4. 뒤로가기
	 * 메뉴 선택 : 3
	 * 
	 * ----------------------------------------------
	 * 
	 * 메뉴
	 * 1. 단어장 목록
	 * 2. 테스트 하기
	 * 3. 종료하기
	 * 메뉴 선택 : 2
	 * 
	 * ------------------------------------------------
	 * 
	 * -------영단어 테스트-------
	 * 전체 문제 ?개 / 1번째 문제
	 * 문제 : 사과
	 * 영단어 : make
	 * 
	 * --------------------------------------------------
	 * 
	 * 전체 문제 n개 / 맞춘 개수 1개
	 * 
	 * 더 공부하세요.
	 * or
	 * 100점 입니다. 새로운 단어장으로 교체하세요.
	 * 
	 * --------------------------------------------------
	 * 
	 * 메뉴
	 * 1. 단어장 목록
	 * 2. 테스트 하기
	 * 3. 종료하기
	 * 메뉴 선택 : 3
	 * 
	 * 프로그램 종료
	 * 
	 * -----------------------------------------------------
	 * 
	 * 
	 * 3.필요한 메서드 구현                                                            
	 * 
	 * 
	 */

	public static void main(String[] args) {
		//반복문
		int menu;
		do {
			//메뉴출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 기능 실행
			runMenu(menu);
		}while(menu != 3);
	}
	
	private static void printMenu() {
		System.out.println("-------- 메뉴 --------");
		System.out.println("1. 단어장 목록");
		System.out.println("2. 테스트 하기");
		System.out.println("3. 종료하기");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//단어장 목록을 출력.
			printWord();
			break;
		case 2:
			//단어 테스트 기능을 구현
			runTest();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private static void printWord() {
		int submenu;
		//게시글 목록을 출력. 번호가 높은 순으로
		do {
			System.out.println("------- 단어장 목록 ---------");
			for(int i = count; i > 0; i--) {
				wordList[i-1].printInfo();
			}
			System.out.println("--------------------------");
			//서브메뉴를 출력
			printSubmenu();
			//서브메뉴 선택
			submenu = scan.nextInt();
			//서브메뉴 맞는 기능 실행
			runSubmenu(submenu);
		}while(submenu != 4);
	}

	private static void printSubmenu() {
		System.out.println("1. 단어 저장하기");
		System.out.println("2. 단어 수정하기");
		System.out.println("3. 단어 삭제하기");
		System.out.println("4. 뒤로가기");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 :");
	}
	
	private static void runSubmenu(int submenu) {
		switch(submenu) {
		case 1:
			//단어 저장하기
			insertWord();
			break;
		case 2:
			//단어 수정
			updateWord();
			break;
		case 3:
			//단어 삭제
			deleteBoard();
			break;
		case 4:
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	private static void insertWord() {
		scan.nextLine();	//입력 버퍼에 남아있는 엔터 처리
		System.out.println();
		//영단어, 한글 순으로 입력받음
		System.out.print("영단어 : ");
		String eng = scan.nextLine();
		System.out.print("한글 : ");
		String kor = scan.nextLine();
		System.out.println("--------------------");
		//입력받은 정보들을 이용하여 게시글 인스턴스를 생성
		Word word = new Word(eng, kor);
		//생성된 인스턴스를 배열에 저장(몇번지)
		wordList[count++] = word;
		//배열 크기를 안늘려도 되면 종료
		if(count < wordList.length) {
			return;
		}
		//배열이 꽉 차면 배열을 늘려줌
		//기존 배열보다 큰 배열 생성
		Word[] tmpList = new Word[wordList.length + 5];
		//새로 생성된 배열에 기존 배열을 복사
		System.arraycopy(wordList, 0, tmpList, 0, count);
		//새로 생성된 배열을 boardList 연결
		wordList = tmpList;
	}
	
	private static void updateWord() {
		//수정할 게시글 번호와 제목, 내용을 입력
		System.out.print("수정할 단어의 번호 : ");
		int num = scan.nextInt();
		//반복문 : 게시글 목록 전체
		for(int i = 0; i < count; i++) {
			//입력한 게시글 번호와 일치하는 게시글이 있으면
			if(num == wordList[i].getNum()) {
				scan.nextLine();
				System.out.print("영단어 수정 : ");
				String title = scan.nextLine();
				System.out.print("한글 수정 : ");
				String contents = scan.nextLine();
				//해당 게시글의 제목과 내용을 수정하고 메서드 종료
				wordList[i].update(title, contents);
				return;	//일치하는 게시물이 있다면 끝내고 없다면 밑에 프린트문구를 실행하기 위해
			}
		}
		//일치하는 게시글이 없습니다라고 출력
		System.out.println("일치하는 단어가 없습니다.");
	}
	
	private static void deleteBoard() {
		//삭제할 게시글 번호를 입력
		System.out.print("삭제할 단어의 번호 : ");
		int num = scan.nextInt();
		//반복문 : 게시글 목록 전체
		int index = -1; // 일치하는 게시글이 있는 번지
		for(int i = 0; i < count; i++) {
			//입력한 번호와 일치하는 게시글을 찾아 번지를 저장
			if(num == wordList[i].getNum()) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		count--;
		Word.setCount(Word.getCount()-1);
		//가장 최근에 등록된 게시글을 삭제했다면
		//== 배열에서 가장 마지막에 있는 게시글을 삭제했다면
		if(index == count) {
			return;
		}
		//찾은 번지 다음부터 한칸씩 당겨옴
		//기존 배열과 크기가 같은 새 배열을 생성
		Word []tmpList = new Word[wordList.length];
		//새 배열에 기존 배열을 복사
		System.arraycopy(wordList, 0, tmpList, 0, wordList.length);
		//기존 배열에서 찾은 번지 다음부터 나머지 개수를 복사해서
		//새 배열에 찾은 번지부터 덮어씀
		System.arraycopy(tmpList, index+1, wordList, index, count - index);
		//게시글의 번호 재설정
		for(int i = index; i < count; i++) {
			wordList[i].setNum(wordList[i].getNum() - 1);
		}
	}

	private static void runTest() {
		int t_Num = 1;
		int t_Count = 0;
		int min = 1, max = count;
		//랜덤번호로 출제
		if(count != 0) {
			int arr[] = new int[count];
			if(createRandomArray(min, max, arr)) {
				for(int i = 0; i < count; i++) {
					scan.nextLine();
					//문제 출력
					System.out.println("-------영단어 테스트-------");
					System.out.println("전체 문제 " + count + "개 / " + t_Num + "번째 문제");
					System.out.println("문제 : " + wordList[arr[i] - 1].getKor());
					System.out.print("영단어 : ");
					String t_Eng = scan.next();
					//내가쓴 단어와 저장된 단어가 같은지 확인
					if(wordList[arr[i] - 1].equals(t_Eng)) {
						//맞추면 맞춘개수++
						t_Count++;
					}
					t_Num++;
				}
			}
		}else {
			System.out.println("저장된 영단어가 없습니다.");
		}
		
		//결과창
		System.out.println("전체 문제 " + count + "개 / 맞춘 개수 " + t_Count + "개");
		if(count == t_Count) {
			System.out.println("100점 입니다. 새로운 단어장으로 교체하세요.");
		}else {
			System.out.println("더 공부하세요.");			
		}
	}
	
	public static boolean createRandomArray(int min, int max, int []arr) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		//max가 min보다 작으면
		if(max < min) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		//배열의 크기가 min~max사이의 정수 개수보다 클 때 
		if(arr.length > max - min + 1) {
			return false;
		}
		//반복문 : 저장된 숫자의 개수가 배열의 크기보다 작을 때 반복
		int count = 0;//저장된 숫자의 개수
		while(count < arr.length) {
			//랜덤수 생성
			int r = random(min, max);
			//중복 확인
			if(!contains(arr, count, r)) {
				//중복되지 않으면 배열에 저장
				arr[count] = r;
				//저장된 숫자의 개수를 1 증가
				count++;
			}
		}
		return true;
	}
	
	public static boolean contains(int [] arr, int n, int num) {
		//배열 생성이 안됐거나 크기가 0이면
		if(arr == null || arr.length == 0) {
			return false;
		}
		//배열의 크기보다 비교할 개수가 많으면
		if(arr.length < n) {
			n = arr.length; //비교할 개수를 배열의 크기로 수정
		}
		for(int i = 0; i < n; i++) {
			//배열에 num와 같은 값이 있으면
			if(arr[i] == num) {
				return true;
			}
		}
		//반복문이 끝날때까지 같은게 없으면
		return false;
	}
	
	public static int random(int min, int max) {
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		return (int)(Math.random() * (max - min + 1) + min);
	}
}
