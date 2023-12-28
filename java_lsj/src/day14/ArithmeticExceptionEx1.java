package day14;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExceptionEx1 {

	public static void main(String[] args) {
		//두 정수와 산술 연산자를 입력받아 산술연산하는 코드를 작성하세요.
		//단, 0으로 나눌 때 예외처리를 적용
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력 (예:1 + 2) : ");
		try {
			int num1 = scan.nextInt();
			char op = scan.next().charAt(0);
			int num2 = scan.nextInt();
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
			case '/':
				result = (double)num1 / num2;
				break;
			}
			pattern = "{0} {1} {2} = {3}";
			str1 = MessageFormat.format(pattern, num1, op, num2, result);
			System.out.println(str1);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없습니다.");
		}catch(InputMismatchException e) {
			System.out.println("입력을 잘 못했습니다.");
		}
		scan.close();
	}

}
