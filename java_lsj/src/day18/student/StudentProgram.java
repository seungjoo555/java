package day18.student;

import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class StudentProgram implements Program {

	private StudentManager sm = new StudentManager();
	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 4;
	private int port = 5001;
	private String ip = "192.168.30.200";
	
	
	@Override
	public void run() {
		try {
			Socket socket = new Socket(ip, port);
			StudentSocket ss = new StudentSocket(socket);
			int menu = 0;
			sm.setList(ss.receive());
			do {
				//메뉴 출력
				printMenu();
				try {
					//메뉴 선택
					menu = scan.nextInt();
					//메뉴 실행
					runMenu(menu);
				} catch (InputMismatchException e) {
					System.out.println("메뉴 선택을 다시 해주세요.");
					scan.nextLine();
				}
			}while(menu != EXIT);
			ss.send(sm.getList());
		} catch (Exception e) {
			System.out.println("연결 실패");
		}
	}

	@Override
	public void printMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 목록 조회");
		System.out.println("3. 학생 목록 저장");	
		System.out.println("4. 종료");
		System.out.println("-------------------------");
		System.out.print("메뉴선택 : ");
	}
	
	public void printExit() {
		System.out.println("-------------------");
		System.out.println("-----프로그램 종료-----");
		System.out.println("-------------------");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			//학생 등록
			insertStudent();
			break;
		case 2:
			//학생 목록 조회
			printStudent();
			break;
		case 3:
			//저장
			break;
		case 4:
			//종료
			printExit();
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void insertStudent() {
		//학생 정보 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		String name = scan.next();
		//학생 객체 생성
		Student std = new Student(grade, classNum, num, name);
		//추가를 해서 성공하면 알림, 실패하면 실패 알림
		if(sm.insertStudent(std)) {
			System.out.println("학생을 추가 했습니다.");
			return;
		}
		System.out.println("이미 등록된 학생입니다.");
	}
	
	private void printStudent() {
		sm.printAll();
	}
	
	
}
