package day08;

import java.util.Scanner;

public class StudentProgram {
	/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.
	 * - 1반의 성적을 관리
	 * - 최대 30명
	 * - 성적은 번호순으로 관리
	 * - 성적은 국어, 영어, 수학 성적을 관리
	 * 메뉴
	 * 1.성적 수정
	 * 2.성적 조회
	 * 3.프로그램 종료
	 * 메뉴 선택 :
	 * 
	 * --성적 수정--
	 * 1.국어
	 * 2.영어
	 * 3.수학
	 * 과목 선택 :
	 * 
	 * 학생 선택 : 3	//번호를 선택
	 * 성적 입력 : 100
	 * 
	 * --성적 조회--
	 * 1. 과목별 조회
	 * 2. 학생별 조회
	 * 선택 : 1
	 * 
	 * --과목별조회--
	 * 1.국어
	 * 2.영어
	 * 3.수학
	 * 과목 선택 : 1
	 * 1번 : 0점
	 * 2번 : 0점
	 * 3번 : 100점
	 * ...
	 * 30번 : 0점
	 * 
	 * --성적 조회--
	 * 1. 과목별 조회
	 * 2. 학생별 조회
	 * 선택 : 2
	 * 학생 선택 : 3
	 * 국어 : 100점
	 * 영어 : 0점
	 * 수학 : 0점
	 */
	public static void main(String[] args) {
		//학년, 이름은 생략하고, 반은 1반으로 고정.
		//번호는 각각 1번부터 5번으로 저장
		Scanner scan = new Scanner(System.in);
		int menu;
		//5명의 학생 정보를 저장할 수 있는 배열을 생성
		int maxStudent = 5;
		Student []student = new Student[maxStudent];
		//각 학생의 번호를 1번부터 5번까지 지정
		//각 학생 인스턴스를 생성
		for(int i = 0; i < student.length; i++) {
			student[i] = new Student();
			//student[i].classNum = 1;
			//student[i].num = 1+i;
		}
		//학생 번호를 수정
		int count = 0;
		//향상된 for문을 이용하여 students를 다른 인스턴스로 교체하는 건 안되지만
		//studens의 멤버변수를 바꾸는 건 가능
		for(Student students : student) {
			//students = new Student();
			students.classNum = 1;
			students.num = 1 + count++;
		}
		//student[0].printInfo();
		//반복문 : 프로그램 종료를 선택하지 않으면 반복
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			System.out.println("-----------------------");
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
				//주어진 학생 정보에 추가 정보를 입력하여 학생 성적을 수정하는 메서드
				updateScore(student, scan);
				break;
			case 2:
				//주어진 학생 정보를 조회하는 기능을 구현하세요. : 메서드
				studentInfo(student, scan);
				break;
			case 3:
				System.out.println("프로그램 종료");				
				break;
			default:
				System.out.println("잘못된 메뉴 선택");
			}
		}while(menu != 3);
		//프로그램 종료를 출력
		scan.close();
	}
	
	//메인 메뉴
	public static void printMenu() {
		System.out.println("***********************");
		System.out.println("메뉴");
		System.out.println("1. 성적 수정");
		System.out.println("2. 성적 조회");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	//성적조회 메뉴
	public static void scoreMenu() {
		System.out.println("-- 성적 조회 --");
		System.out.println("1. 과목별 조회");
		System.out.println("2. 학생별 조회");
		System.out.print("선택 : ");
	}
	
	//
	public static void correctionMenu() {
		System.out.println("--성적 수정--");
		System.out.println("1.국어");
		System.out.println("2.영어");
		System.out.println("3.수학");
		System.out.print("과목 선택 : ");
	}
	
	//과목별 조회
	public static void scoreInfo01(Student[] std, Scanner scan) {
		System.out.println("--과목별 조회--");
		System.out.println("1.국어");
		System.out.println("2.영어");
		System.out.println("3.수학");
		System.out.print("과목 선택 : ");
		int choice = scan.nextInt();
		for(Student stds : std) {
			switch(choice) {
			case 1:
				System.out.println((stds.num)+"번 : " + stds.kor +"점");
				break;
			case 2:
				System.out.println((stds.num)+"번 : " + stds.eng +"점");
				break;
			case 3:
				System.out.println((stds.num)+"번 : " + stds.math +"점");
				break;
			default:
				System.out.println("과목을 다시 선택해 주세요.");
			}			
		}
	}
	//학생별 조회
	public static void scoreInfo02(Student[] std, Scanner scan) {
		System.out.print("학생 선택 : ");
		int stdNum = scan.nextInt();
		for(Student stds : std) {
			if(stds.num == stdNum) {
				stds.printScore();
				return;
			}
		}
		System.out.println("일치하는 학생이 없습니다.");
	}
	
	//성적 조회 구현
	public static void studentInfo(Student[] std, Scanner scan) {
		int tmp;
		//성적조회 메뉴
		scoreMenu();
		tmp = scan.nextInt();
		//과목별, 학생별 조회 선택
		switch(tmp) {
		case 1:
			scoreInfo01(std, scan);
			break;
		case 2:
			scoreInfo02(std, scan);
			break;
		default:
			System.out.println("1또는 2를 선택해 주세요.");
		}
	}
	
	//성적 수정 구현
	public static void updateScore(Student[] std, Scanner scan) {
		//과목선택
		correctionMenu();
		int subject = scan.nextInt();
		System.out.print("학생 선택 : ");
		int num = scan.nextInt();
		System.out.print("성적 입력 : ");
		int tmp = scan.nextInt();
		for(Student stds : std) {
			if(stds.num != num) {
				continue;
			}
			switch(subject) {
			case 1:
				stds.setKor(tmp);
				return;
			case 2:
				stds.setEng(tmp);
				return;
			case 3:
				stds.setMath(tmp);
				return;
			}
		}
		System.out.println("과목 또는 학생 번호가 잘못 됐습니다.");
	}
}
