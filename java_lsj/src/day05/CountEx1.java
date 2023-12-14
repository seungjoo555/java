package day05;

import java.util.Scanner;

public class CountEx1 {

	public static void main(String[] args) {
		/* 1에서 9사이의 정수를 10개 입력받아
		 * 각 숫자가 몇개씩 입력됐는지 출력하는 코드를 작성하세요.
		 * 1 2 3 1 2
		 * 1 : 2
		 * 2 : 2
		 * 3 : 1
		 * 4 : 0
		 * 5 : 0
		 * ....
		 * 9 : 0
		 */
		Scanner scan = new Scanner(System.in);
		int num[] = new int[9];
		int user[] = new int[5];
		
		for (int i = 0; i < user.length; i++) {
			System.out.print((1+i) + "번째 정수 입력중(1~9) : ");
			user[i] = scan.nextInt();
			num[user[i]-1]++;
		}
		
		for(int j = 0; j < num.length; j++) {
			System.out.println((1+j) + " : " + num[j]);
		}
		
		scan.close();
	}

}
