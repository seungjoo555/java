package day06;

import java.util.Scanner;

public class ArithmeticEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 산수(+, -, *) 문제를 생성하여 맞추는 게임
		 * 1 + 2 = 3
		 * 정답입니다.
		 * 
		 * 2 * 3 = 5
		 * 틀렸습니다.
		 */
		Scanner scan = new Scanner(System.in);
		while(true) {
			int userNum = 0;
			int dap = 0;
			
			//랜덤한 정수 2개
			int min = 1, max = 99;
			int num1 = (int)(Math.random() * (max - min + 1) + min);
			int num2 = (int)(Math.random() * (max - min + 1) + min);
			
			//+, -, * 만들기
			int r_op = (int)(Math.random() * 3);
			String str = "+-*";
			char op = str.charAt(r_op);
			switch(op) {
			case '+':	dap = num1 + num2;	break;
			case '-':	dap = num1 - num2;	break;
			case '*':	dap = num1 * num2;	break;
			}
			System.out.print(""+num1 + op + num2 + " = ");
			userNum = scan.nextInt();
			
			if(userNum == dap) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
				break;
			}
		}
		scan.close();
	}

}
