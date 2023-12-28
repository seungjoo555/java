package day14;

import java.text.MessageFormat;
import java.util.Scanner;

public class ArithmeticExceptionEx2 {

	//두 정수와 산술연산자를 입력받아 결과를 출력하는 메서드를 구현하세요.
	//메서드를 이용, throws와 throw를 이용
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("입력 (예:1 + 2) : ");
			try {
				int num1 = scan.nextInt();
				char op = scan.next().charAt(0);
				int num2 = scan.nextInt();
				Calculator(num1, num2, op);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				break;
			}
		}while(true);
		
		scan.close();
	}

	public static void Calculator(int num1, int num2, char op) throws RuntimeException{
		double result = 0;
		String pattern;
		String str1;
		switch(op) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '%':
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			result = num1 % num2;
			break;
		case '/':
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			result = num1 / (double)num2;
			break;
		default : 
			throw new RuntimeException(op + "는 산술 연산자가 아닙니다.");
		}
		pattern = "{0} {1} {2} = {3}";
		str1 = MessageFormat.format(pattern, num1, op, num2, result);
		System.out.println(str1);
	}
	
}
