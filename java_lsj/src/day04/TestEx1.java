package day04;

import java.util.Scanner;

public class TestEx1 {

	public static void main(String[] args) {
		/* 
		 * Scanner 를 이용하여 국어, 영어, 수학 성적을 입력받고,
		 * 총점과 평균을 구하는 코드를 작성하세요.
		 */

		Scanner scan = new Scanner(System.in);
		int sum = 0;
		double avg = 0;
		
		
		System.out.print("국어 점수 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학 점수 입력 : ");
		int math = scan.nextInt();
		
		sum = kor + eng + math;
		avg = sum / 3.0;
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		
		scan.close();
	}

}
