package day04;

import java.util.Scanner;

public class GcdEx3 {

	public static void main(String[] args) {
		/*
		 * 두 정수의 최대 공약수를 구하는 코드를 작성하세요.
		 * 최대 공약수 : 공약수 중 가장 큰 공약수
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 가지고 있는 약수
		 * 12의 약수 : 1, 2, 3, 4, 6, 12
		 * 8의 약수  : 1, 2, 4, 8
		 * 8과 12의 공약수 : 1, 2, 4
		 * 8과 12의 최대 공약수 : 4
		 * 
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		
		/*
		System.out.print("첫번째 정수 : ");
		int num1 = scan.nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = scan.nextInt();
		
		System.out.print(num1 + ", " + num2 +" 의 최대공약수는 : ");
		for(int i = num1; i >= 1; i--) {
			if(num1 % i == 0 && num2 % i == 0) {
				System.out.print(i);
				break;
			}
		}
		
		*/
		
		//---------------------------------------------------------
		
		int num1 = 8, num2 = 12;
		int gcd = 0;
		
		for(int i = 1; i <= num1; i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		System.out.print(num1 + ", " + num2 +" 의 최대공약수는 : " + gcd);
		
		
		
		
		scan.close();
	}

}
