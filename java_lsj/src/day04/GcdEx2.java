package day04;

import java.util.Scanner;

public class GcdEx2 {

	public static void main(String[] args) {
		/*
		 * 두 정수의 공약수를 출력하는 코드를 작성하세요.
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 가지고 있는 약수
		 * 12의 약수 : 1, 2, 3, 4, 6, 12
		 * 8의 약수  : 1, 2, 4, 8
		 * 8과 12의 공약수 : 1, 2, 4
		 */
		Scanner scan = new Scanner(System.in);
		/*
		System.out.print("첫번째 정수 : ");
		int num1 = scan.nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = scan.nextInt();
		
		System.out.print(num1 + ", " + num2 +" 의 공약수는 : ");
		for(int i = 1; i <= num1; i++) {
			if(num1 % i == 0) {
				if(num2 % i == 0) {
					System.out.print(i + " ");
				}
			}
		}
		
		*/
		//-----------------------------------------------------------------
		int num1 = 8, num2 = 12;
		
		System.out.print(num1 + ", " + num2 +" 의 공약수는 : ");
		for(int i = 1; i <= num1; i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				System.out.print((i == 1 ? "" : ", ") + i);
			}
		}
		
		
		
		
		
		
		scan.close();
	}

}
