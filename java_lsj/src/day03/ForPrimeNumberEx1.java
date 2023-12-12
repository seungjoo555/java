package day03;

import java.util.Scanner;

public class ForPrimeNumberEx1 {

	public static void main(String[] args) {
		/*
		 * 소수 판별 예제
		 * 입력한 정수가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수는 약수가 2개인 수.
		 * 약수는 어떤 수를 나누었을 때 나머지가 0이 되게 하는 수.
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("임의의 정수를 입력 : ");
		int num = scan.nextInt();
		int pn = 0;
		
		for (int i = 2; i <= num ; i++) {
			if (num % i == 0) {
				pn++;
			}
		}
		
		if(pn == 1) {
			System.out.println(num + "은 소수입니다.");
		}else {
			System.out.println(num + "은 소수가 아닙니다.");
		}
		
		scan.close();
	}

}
