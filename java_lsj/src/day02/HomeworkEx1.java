package day02;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/*
		 * 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * 90이상 ~ 100이하 : A
		 * 80이상 ~ 90미만 : B
		 * 70이상 ~ 80미만 : C
		 * 60이상 ~ 70미만 : D
		 * 60미만 : F
		 * 0보다 작거나 100보다 큰 경우 : 잘못된 점수
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("성적을 입력하세요 : ");
		int score = scan.nextInt();
		
		if(score < 0 || score > 100) {
			System.out.println("잘못된 점수 입니다. 다시 입력해 주세요.");
		}else if(score >= 90) {
			System.out.println("A 학점 입니다.");
		}else if(score >= 80) {
			System.out.println("B 학점 입니다.");
		}else if(score >= 70) {
			System.out.println("C 학점 입니다.");
		}else if(score >= 60) {
			System.out.println("D 학점 입니다.");
		}else {
			System.out.println("F 학점 입니다.");
		}
		
		scan.close();
		//강사님 코드
		/*
		Scanner scan = new Scanner(System.in);
		System.out.println("성적 입력(0~100) :");
		int score = scan.nextInt();
		
		if(score >= 90 && score <= 100) {
			System.out.println(score + "점은 A");
		}
		else if (score >= 80 && score < 90) {
			System.out.println(score + "점은 B");
		}
		else if (score >= 70 && score < 80) {
			System.out.println(score + "점은 C");
		}
		else if (score >= 60 && score < 70) {
			System.out.println(score + "점은 D");
		}
		else if (score >= 0 && score < 60) {
			System.out.println(score + "점은 F");
		}
		else {
			System.out.println("잘못된 점수");			
		}		
		scan.close();
		*/
	}

}
