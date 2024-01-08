package teacher.day20;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;
import teacher.day20.service.FileService;
import teacher.day20.service.FileServiceImp;
import teacher.day20.service.PrintService;
import teacher.day20.service.PrintServiceImp;

public class WordProgram implements Program {

	private final int EXIT = 5;
	private final int WORD_EXIT = 4;
	private final int MEAN_EXIT = 4;
	private final int PRINT_EXIT = 4;
	private final int GAME_EXIT = 4;
	
	private Scanner scan = new Scanner(System.in);
	private PrintService printService= new PrintServiceImp();
	private FileService fileService = new FileServiceImp();
	
	private Vocabulary vocabulary = new Vocabulary(null);
	private List<Word> wrongList = new ArrayList<Word>();
	
	@Override
	public void run() {
		int menu = 0;
		String fileName = "src/teacher/day20/wordList.txt";
		//불러오기
		List<Word> list = fileService.load(fileName);
		vocabulary = new Vocabulary(list);
		do {
			try {
				printMenu();
				//메뉴 선택
				menu = scan.nextInt();
				runMenu(menu);
			} catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
			
		}while(menu != EXIT);
		//저장하기
		if(fileService.save(fileName, vocabulary.getList())) {
			System.out.println("저장이 완료되었습니다.");
		}else {
			System.out.println("저장에 실패했습니다.");			
		}
	}

	@Override
	public void printMenu() {
		printService.printMainMenu();
		
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			wordManage();
			break;
		case 2:
			meanManage();
			break;
		case 3:
			printManage();
			break;
		case 4:
			gameManage();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	

	private void wordManage() {
		int menu = 0;
		do {
			//단어 관리 메뉴 출력
			printService.printWordMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//메뉴 실행
			runWordMenu(menu);
		}while(menu != WORD_EXIT);
	}

	private void runWordMenu(int menu) {
		switch(menu) {
		case 1:
			addWord();
			break;
		case 2:
			setWord();
			break;
		case 3:
			removeWord();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void removeWord() {
		//삭제할 단어 입력
		System.out.println("삭제할 단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		//단어삭제
		if(vocabulary.removeWord(word)) {
			System.out.println("단어를 삭제했습니다.");
		}else {
			System.out.println("없는 단어입니다.");
		}
	}

	private void setWord() {
		//수정할 단어와 새 단어를 입력
		System.out.print("수정할 단어 : ");
		scan.nextLine();
		String oldWord = scan.nextLine();
		System.out.print("새 단어 : ");
		String newWord = scan.nextLine();
		
		//단어를 수정
		if(vocabulary.setWord(oldWord, newWord)) {
			System.out.println("단어를 수정했습니다.");
		}else {
			//없는 단어를 수정하려고 했거나 이미 등록된 단어로 수정하려고 할 때
			System.out.println("단어를 수정하지 못했습니다.");
		}
	}

	private void addWord() {
		//단어, 품사, 뜻을 입력
		System.out.print("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		char isContinue = 'n';
		//뜻들을 저장할 리스트
		List<Mean> meanList = new ArrayList<Mean>();
		do {
			System.out.print("품사 : ");
			String partOfSpeech = scan.next();
			System.out.print("의미 : ");
			scan.nextLine();
			String mean = scan.nextLine();
			
			meanList.add(new Mean(partOfSpeech, mean));
			System.out.print("의미를 더 추가?(y/n) : ");
			isContinue = scan.next().charAt(0);
		}while(isContinue == 'y');
		//단어장이 비어 있으면
		if(vocabulary == null) {
			System.out.println("단어장이 없습니다.");
		}
		
		//단어장에 추가
		if(vocabulary.addWord(word, meanList)) {
			System.out.println("단어를 추가했습니다.");
		}else {
			System.out.println("뜻과 단어가 이미 등록된 상태입니다.");
		}
		System.out.println(vocabulary);
	}

	private void meanManage() {
		int menu = 0;
		do {
			//뜻관리 메뉴
			printService.printMeanMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//메뉴 실행
			runMeanMenu(menu);
		}while(menu != MEAN_EXIT);
	}

	private void runMeanMenu(int menu) {
		switch(menu) {
		case 1:
			addMean();
			break;
		case 2:
			setMean();
			break;
		case 3:
			removeMean();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void removeMean() {
		//단어 입력
		System.out.println("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		//입력한 단어와 일치하는 단어 객체를 가져옴
		Word selectedWord = vocabulary.getWord(word);
		//없는 단어이면 알림
		if(selectedWord == null) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		//단어가 있으면 단어와 뜻을 출력
		selectedWord.printWord();
		
		//삭제할 의미의 번호를 입력
		System.out.println("삭제할 의미 번호: ");
		int index = scan.nextInt() - 1;
		
		//해당 단어의 의미를 삭제 후 알림
		if(selectedWord.removeMean(index)) {
			System.out.println("의미를 삭제했습니다.");
		}else {
			System.out.println("의미를 삭제하지 못했습니다.");
		}
		
	}

	private void setMean() {
		//단어 입력
		System.out.println("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		//입력한 단어와 일치하는 단어 객체를 가져옴
		Word selectedWord = vocabulary.getWord(word);
		//없는 단어이면
		if(selectedWord == null) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		//수정할 뜻 선택
		int index = scan.nextInt() - 1;
		//수정할 품사, 뜻을 입력
		System.out.print("수정할 품사 : ");
		String partOfSpeech = scan.next();
		System.out.println("수정할 의미 : ");
		scan.nextLine();
		String mean = scan.nextLine();
		//뜻을 수정
		if(selectedWord.setMean(index,  partOfSpeech, mean)) {
			System.out.println("의미를 수정했습니다.");
		}else {
			System.out.println("의미를 수정하지 못했습니다.");
		}
	}

	private void addMean() {
		//뜻을 추가할 단어 입력, 품사, 뜻 입력
		System.out.print("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		
		System.out.print("품사 : ");
		String partOfSpeech = scan.next();
		
		System.out.print("의미 : ");
		String mean = scan.next();
		
		if(vocabulary.addMean(word, partOfSpeech, mean)) {
			System.out.println("의미 추가 성공");
		}else {
			System.out.println("이미 있는 단어");                                                                                                                                      
		}
	}

	private void printManage() {
		int menu;
		do {
			//조회 메뉴 출력
			printService.printPrintMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//메뉴 실행
			runPrintMenu(menu);
		}while(menu != PRINT_EXIT);
	}
	
	private void runPrintMenu(int menu) {
		switch(menu) {
		case 1:
			printAll();
			break;
		case 2:
			printSearch();
			break;
		case 3:
			printAllByViews();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void printAllByViews() {
		vocabulary.printByViews();
	}

	private void printSearch() {
		//검색할 단어 입력
		System.out.print("검색어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		
		//단어장에 검색어를 주면서 검색어를 포함하는 단어들을 출력하라고 요청
		vocabulary.print(word);
		//
		
		//
	}

	private void printAll() {
		vocabulary.print();
	}

	private void gameManage() {
		int menu;
		do {
			//메뉴 출력
			printService.printGameMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//메뉴 실행
			runGameMenu(menu);
		}while(menu != GAME_EXIT);
		
		
	}

	private void runGameMenu(int menu) {
		switch(menu) {
		case 1:
			gamestart();
			break;
		case 2:
			break;
		default:
		}
	}

	private void initWrongList() {
		if(wrongList == null) {
			wrongList = new ArrayList<Word>();
		}
		wrongList.clear();
	}
	
	private void printWrongList() {
		if(wrongList.size() == 0) {
			System.out.println("오답이 없습니다.");
			return;
		}
		wrongList.stream().forEach(w->w.printWord());
	}
	
	
	private void gamestart() {
		/*
		if(mean == null) {
			continue;
		}
		System.out.println("의미 : " + mean);
		System.out.println("단어 : ");
		scan.nextLine();
		*/
	}

	
	
	
}
