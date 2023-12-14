package day05;

import java.util.Scanner;

public class ArrayEx1 {

	//배열 예제
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		//아래 반복문은 변수명에 i가 들어가도 변수명에 i는 바뀌지 않기 때문에 불가능
		/*
		for(int i = 1; i <=5; i++) {
			kori = scan.nextInt();
		}
		*/
		
		//학생 5명의 국어 성적을 저장하기 위한 배열
		int[] korScores = new int[5];
		
		for(int i = 0; i < 5; i++) {
			System.out.print((i+1)+"번 학생의 성적을 입력: ");
			korScores[i] = scan.nextInt();
		}
		for(int i = 0; i < 5; i++) {
			System.out.println((i+1)+"번 학생의 성적: " + korScores[i]);
		}
		
		scan.close();
	}

}
