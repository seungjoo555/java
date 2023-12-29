package day15.student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentProgram implements Program {
	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 4;
	private List<Student> list = new ArrayList<Student>();
	
	@Override
	public void printMenu() {
		System.out.println("---------메뉴---------");
		System.out.println("1. 학생 관리");
		System.out.println("2. 성적 관리");
		System.out.println("3. 조회");
		System.out.println("4. 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			//학생 관리
			studentManagement();
			break;
		case 2:
			//성적 관리
			scoreManagement();
			break;
		case 3:
			//조회
			check();
			break;
		case 4:
			//종료
			printExit();
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void check() {
		int menu = 0;
		do {
			//조회 메뉴
			printCheckMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//기능 실행
			runCheck(menu);
		}while(menu != 8);
	}

	private void printCheckMenu() {
		System.out.println("----------------");
		System.out.println("--학생 조회--");
		System.out.println("1. 전체");
		System.out.println("2. 학년");
		System.out.println("3. 반");
		System.out.println("4. 학생");
		System.out.println("--성적 조회--");
		System.out.println("5. 국어");
		System.out.println("6. 영어");
		System.out.println("7. 수학");
		System.out.println("8. 뒤로 가기");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
	}

	private void runCheck(int menu) {
		int grade, classNum, num;
		switch(menu) {
		case 1:
			//전체 조회
			printStudent(s->true);
			break;
		case 2:
			System.out.print("학년 : ");
			grade = scan.nextInt();
			printStudent(s->s.getGrade() == grade);
			break;
		case 3:
			System.out.print("학년 : ");
			grade = scan.nextInt();
			System.out.print("반 : ");
			classNum = scan.nextInt();
			printStudent(s->s.getGrade() == grade && s.getClassNum() == classNum);
			break;
		case 4:
			System.out.print("학년 : ");
			grade = scan.nextInt();
			System.out.print("반 : ");
			classNum = scan.nextInt();
			System.out.print("번호 : ");
			num = scan.nextInt();
			Student std = new Student(grade, classNum, num, "");
			printStudent(s->s.equals(std));
			break;
		case 5:
			System.out.println("국어");
			printSubject(s->s.getKor());
			break;
		case 6:
			System.out.println("영어");
			printSubject(s->s.getEng());
			break;
		case 7:
			System.out.println("수학");
			printSubject(s->s.getMath());
			break;
		case 8:
			//뒤로 가기
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void printStudent(Predicate<Student> p) {
		for(Student std : list) {
			if(p.test(std)) {
				System.out.println(std);
			}
		}
	}
	
	private void printSubject(Function<Student, Integer> f) {
		for(Student std : list) {
			System.out.println(std.getName() + " : " + f.apply(std));
		}
	}
	
	private void scoreManagement() {
		int menu = 0;
		do {
			//성적 관리 메뉴
			printScoreMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//기능 실행
			runScoreM(menu);
		}while(menu != 2);
	}

	private void printScoreMenu() {
		System.out.println("----------------");
		System.out.println("1. 성적 수정");
		System.out.println("2. 뒤로 가기");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
	}

	private void runScoreM(int menu) {
		switch(menu) {
		case 1:
			//성적 수정
			updateScore();
			break;
		case 2:
			//뒤로가기
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void updateScore() {
		//과목 출력 : 수정할 과목을 선택
		System.out.print("국어(1)영어(2)수학(3): ");
		//과목 선택
		int subject = scan.nextInt();
		//학년, 반, 번호, 성적을 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("성적 : ");
		int score = scan.nextInt();

		//학년, 반, 번호를 이용해서 인스턴스 생성
		Student std = new Student(grade, classNum, num, "");
		
		//생성된 학생이 있는지 확인하고 없으면 없다고 알림 후 종료
		int index = list.indexOf(std);
		if(index == -1) {
			System.out.println("등록되지 않은 학생입니다.");
			return;
		}
		//있으면 선택한 과목에 맞는 성적을 수정
		switch(subject) {
		case 1: list.get(index).setKor(score); break;
		case 2: list.get(index).setEng(score); break;
		case 3: list.get(index).setMath(score); break;
		default:
			throw new InputMismatchException();
		}
		System.out.println("성적 수정이 완료 됐습니다.");
		//System.out.println(list.get(index));	//확인용
	}

	private void studentManagement() {
		int menu = 0;
		do {
			//학생 관리 메뉴
			printStudentMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//기능 실행
			runSM(menu);
		}while(menu != 4);
	}

	private void printStudentMenu() {
		System.out.println("----------------");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
	}

	private void runSM(int menu) {
		switch(menu) {
		case 1:
			//학생추가
			insertStudent();
			break;
		case 2:
			//학생 수정
			updateStudent();
			break;
		case 3:
			//학생 삭제
			deleteStudent();
			break;
		case 4:
			//뒤로가기
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	

	private void deleteStudent() {
		//삭제할 학년, 반, 번호를 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		
		//학생 인스턴스를 생성
		Student std = new Student(grade, classNum, num, "");
		
		//삭제 요청 후 삭제되면 삭제됐다고 알림, 삭제 안되면 삭제 안됐다고 알림
		if(list.remove(std)) {
			System.out.println("학생 정보가 삭제 되었습니다.");
		}else {
			System.out.println("등록되지 않은 학생 정보입니다.");
		}
	}

	private void updateStudent() {
		//기존 학년, 반, 번호를 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		
		Student std = new Student(grade, classNum, num, "");
		//기존 학년, 반, 번호와 일치하는 학생 인스턴스를 가져옴
		int index = list.indexOf(std);
		//없으면 없다고 하고 종료
		if(index == -1) {
			System.out.println("등록되지 않은 학생입니다");
			return;
		}
		
		std = list.get(index);	//기존 학생 정보
		
		//수정할 학년, 반, 번호, 이름을 입력
		System.out.print("수정할 학년 : ");
		grade = scan.nextInt();
		System.out.print("수정할 반 : ");
		classNum = scan.nextInt();
		System.out.print("수정할 번호 : ");
		num = scan.nextInt();
		System.out.print("수정할 이름 : ");
		scan.nextLine();
		String name = scan.next();
		
		//수정할 학생 인스턴스를 생성
		Student newStd = new Student(grade, classNum, num, name);
		
		//수정할 학생 정보가 있는지 확인해서 있으면 알림 후 종료
		if(list.contains(newStd)) {
			System.out.println("이미 등록된 학생 정보이어서 수정할 수 없습니다.");
			return;
		}
		//수정할 학생 인스턴스에 기존 학생 성적들을 업데이트하고
		newStd.updateScore(std.getKor(), 
				std.getEng(), std.getMath());
		//기존 학생 정보를 삭제
		list.remove(index);
		//수정할 학생 정보를 리스트에 추가
		list.add(newStd);
		//정렬
		sort();
		
		System.out.println("학생 정보가 수정 되었습니다.");
		System.out.println(list);
	}
	
	private void sort() {
		list.sort((o1,o2)->{
			if(o1.getGrade() != o2.getGrade()) {
				return o1.getGrade() - o2.getGrade();
			}
			if(o1.getClassNum() != o2.getClassNum()) {
				return o1.getClassNum() - o2.getClassNum();
			}
			return o1.getNum() - o2.getNum();
		});
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

	@Override
	public void printExit() {
		System.out.println("-----------------------");
		System.out.println("프로그램을 종료 합니다.");
		System.out.println("-----------------------");
	}

	@Override
	public void run() {
		System.out.println("----------------------");
		System.out.println("프로그램을 실행합니다.");
		System.out.println("----------------------");
		int menu = 0;
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//메뉴별 동작
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();//잘못 입력된 값을 문자열로 가져와서 버림
			}
		}while(menu != EXIT);
	}
}
