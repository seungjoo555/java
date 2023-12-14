package day05;

import java.util.Scanner;

public class ArrayScoreEx1 {

	//배열 예제
	public static void main(String[] args) {
		//학생 5명의 국어 성적을 입력받고, 총점과 평균을 구하는 코드를 작성하세요.
		Scanner scan = new Scanner(System.in);
		
		int student = 5;
		int [] korSco = new int[student];
		int sum = 0;
		double avg = 0.0;
		
		for(int i = 0; i < student; i++) {
			System.out.print((i+1)+"번 학생 성적 입력: ");
			korSco[i] = scan.nextInt();
			sum += korSco[i];
		}
		avg = (double)sum / student;
		
		System.out.println("총점 :" + sum);
		System.out.println("평균 :" + avg);
		
		scan.close();
	}

}
