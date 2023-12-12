package day03;

import java.util.Scanner;

public class GcdEx1 {

	public static void main(String[] args) {
		/*
		 * 정수의 약수를 출력하는 예제를 작성하세요.
		 * 약수는 나누어서 떨어지는 수
		 * 4의 약수 : 1, 2, 4
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력 : ");
		int num = scan.nextInt();
		
		System.out.print(num + "의 약수 : ");
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				System.out.print(i + " ");
			}
		}
		scan.close();
	}

}
