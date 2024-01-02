package day16.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class StudentProgram implements Program{

	private List<Student> list = new ArrayList<Student>();
	private Scanner scan = new Scanner(System.in);
	private String fileName = "src/day16/StudentInfo.txt";
	@Override
	public void run() {
		int menu = 0;
		load(fileName);
		do {
			//메뉴출력
			printMenu();
			try {
				//메뉴선택
				menu = scan.nextInt();
				//메뉴 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();//잘못 입력된 값을 문자열로 가져와서 버림
			}
		}while(menu != 3);
		
		save(fileName);
	}
	
	@Override
	public void save(String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			//학생 추가
			insertStudent();
			break;
		case 2:
			//학생 조회
			printStudent();
			break;
		case 3:
			//종료
			System.out.println("종료");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void insertStudent() {
		//학년, 반, 번호, 이름을 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.next();
		//입력받은 정보로 인스턴스를 생성 std
		Student std = new Student(grade, classNum, num, name);
		//std가 리스트에 있는지 확인해서 없으면 추가
		//contains는 Objects.equals(a, b)를 호출해서 a와 b의 클래스가 같으면
		//a.equals(b)를 이용하여 있는지 없는지 확인
		if(!list.contains(std)) {
			list.add(std);
			System.out.println("학생을 등록했습니다.");
			return;
		}
		//있으면 이미 등록됐다고 알림
		System.out.println("이미 등록된 학생입니다.");
	}

	private void printStudent() {
		list.stream().forEach(s->System.out.println(s));
	}
	
	@Override
	public void printMenu() {
		System.out.println("-----------------");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			list = (List<Student>)ois.readObject();
			System.out.println("학생 정보를 불러왔습니다.");
		} catch (Exception e) {
			System.out.println("불러오기에 실패 했습니다.");
		}
	}
}
