package day03;

import java.util.Scanner;

public class SwitchEx2 {

	//switch 문 예제
	public static void main(String[] args) {
		//정수를 입력받아 입력받은 정수의 홀짝 판별 예제를 switch 문을 이용하여 작성
		Scanner scan = new Scanner(System.in);
		
		System.out.print("임의의 정수를 입력 : ");
		int num = scan.nextInt();
		
		switch(num % 2) {
		case 0:
			System.out.println(num + "은 짝수 입니다.");
			break;
		default:
			System.out.println(num + "은 홀수 입니다.");
		}
		
		
		scan.close();
	}

}
