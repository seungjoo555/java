package day06;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
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
		Scanner scan = new Scanner(System.in);
		int menu;
		int student;
		int maxStudent = 30;
		int []kor = new int[maxStudent],
			eng = new int[maxStudent],
			math = new int[maxStudent];
		
		do {
			System.out.println("***********************");
			System.out.println("메뉴");
			System.out.println("1. 성적 수정");
			System.out.println("2. 성적 조회");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			
			//성적 수정
			if(menu == 1) {
				//과목선택
				int tmp;
				int choice = 0;
				System.out.println("--성적 수정--");
				System.out.println("1.국어");
				System.out.println("2.영어");
				System.out.println("3.수학");
				System.out.print("과목 선택 : ");
				choice = scan.nextInt();
				if(choice < 1 || choice > 3) {
					System.out.println("과목을 다시 선택해 주세요.");
					continue;
				}
				//학생선택
				System.out.print("학생 선택 : ");
				student = scan.nextInt();
				//성적 입력
				System.out.print("성적 입력 : ");
				tmp = scan.nextInt();
				if(choice == 1) {
					kor[student-1] = tmp;
				}else if(choice == 2) {
					eng[student-1] = tmp;
				}else {
					math[student-1] = tmp;
				}
			}
			//성적 조회
			else if(menu == 2) {
				int tmp;
				int choice = 0;
				System.out.println("-- 성적 조회 --");
				System.out.println("1. 과목별 조회");
				System.out.println("2. 학생별 조회");
				System.out.print("선택 : ");
				tmp = scan.nextInt();
				if(tmp < 1 || tmp > 2) {
					System.out.println("1또는 2를 선택해 주세요.");
					continue;
				}
				//과목별, 학생별 조회 선택
				if(tmp == 1) {
					System.out.println("--과목별 조회--");
					System.out.println("1.국어");
					System.out.println("1.영어");
					System.out.println("3.수학");
					System.out.print("과목 선택 : ");
					choice = scan.nextInt();
					if(choice < 1 || choice > 3) {
						System.out.println("과목을 다시 선택해 주세요.");
						continue;
					}
					if(choice == 1) {
						for(int i = 0; i < kor.length; i++) {
							System.out.println((1+i)+"번 : " + kor[i] +"점");
						}
					}else if(choice == 2) {
						for(int i = 0; i < eng.length; i++) {
							System.out.println((1+i)+"번 : " + eng[i] +"점");
						}
					}else {
						for(int i = 0; i < math.length; i++) {
							System.out.println((1+i)+"번 : " + math[i] +"점");
						}
					}
				}else {
					System.out.print("학생 선택 : ");
					student = scan.nextInt();
					System.out.println("국어 :" + kor[student-1] +"점");
					System.out.println("영어 :" + eng[student-1] +"점");
					System.out.println("수학 :" + math[student-1] +"점");
				}
			}
		}while(menu != 3);
		System.out.println("프로그램 종료");
		
		scan.close();
	}

}
