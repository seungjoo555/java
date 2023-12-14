package day05;

import java.util.Scanner;

public class ReverseNumberEx1 {

	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수를 거꾸로 출력하는 코드를 작성하세요.
		 * 예)
		 * 입력 : 1234
		 * 출력 : 4321
		 * 
		 * 예)
		 * 입력 : 1200
		 * 출력 : 0021
		 * Math.pow()
		 */
		Scanner scan = new Scanner(System.in);		
		int count = 0;
		
		System.out.print("입력 : ");
		long num = scan.nextLong();
		long tmp = num;
		
		//몇자리 수인지 판별
		while(tmp >= 1) {
			tmp /= 10;
			count++;
		}
		
		long rev[] = new long[count];
		
		System.out.print("출력 : ");
		for(int i = 0; i < rev.length; i++) {
			rev[i] = num % 10 ;
			num = num / 10;
			System.out.print(rev[i]);
		}
		
		scan.close();
	}

}
