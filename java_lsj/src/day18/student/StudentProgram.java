package day18.student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class StudentProgram implements Program {

	private StudentManager sm = new StudentManager();
	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 3;
	private Socket socket;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	@Override
	public void run() {
		int port = 5001;
		String ip = "192.168.30.200";
		connectServer(ip,port);
		load();
		int menu = 0;
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
	}

	@Override
	public void printMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 목록 조회");
		System.out.println("3. 종료");
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
			//종료
			printExit();
			exit();
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
	
	private void exit() {
		if(socket == null) {
			System.out.println("서버에 연결되지 않았습니다. ");
		}
		try {
			oos.writeUTF("SAVE");
			oos.flush();
			oos.writeObject(sm.getList());
			System.out.println("서버에 저장 완료");
		}catch (Exception e) {
			System.out.println("저장중 예외 발생");
		}
		
	}
	
	private void connectServer(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			System.out.println(socket);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			System.out.println("[서버 연결 성공]");
		} catch (IOException e) {
			System.out.println("[서버 연결 실패]");
		}
		
	}
	
	private void load() {
		if(socket == null) {
			System.out.println("[서버에 연결되지 않아 불러올 수 없습니다.]");
		}
		try {
			oos.writeUTF("LOAD");;
			oos.flush();
			//읽어옴
			List<Student> list = (List<Student>)ois.readObject();
			sm = new StudentManager(list);
			System.out.println("[불러오기 성공]");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[불러오기 중 예외가 발생했습니다.]");
		}
	}
	
}
