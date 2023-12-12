package day03;

import java.util.Scanner;

public class NestedIfEx1 {

	//중첩 if 문 예제
	public static void main(String[] args) {
		// 2의 배수이면 2의 배수라고 출력, 6의 배수이면 6의 배수라고 출력
		// 2, 6의 배수가 아니면 2, 6의 배수가 아님이라고 출력하는 예제
		Scanner scan = new Scanner(System.in);
		
		System.out.print("임의의 정수를 입력 : ");
		int num = scan.nextInt();
		
		//중첩 if 문 사용
		if(num % 2 == 0) {
			if(num % 3 == 0) {
				System.out.println(num + "은 6의 배수");
			}else {
				System.out.println(num + "은 2의 배수");
			}
		}else {
			System.out.println("2, 6의 배수가 아님");			
		}
		
		//중첩 if 문 사용하지 않음
		if(num % 2 == 0 && num % 3 == 0) {
			System.out.println(num + "은 6의 배수");
		}else if(num % 2 == 0) {
			System.out.println(num + "은 2의 배수");
		}else {
			System.out.println("2, 6의 배수가 아님");
		}
		
		
		scan.close();
	}

}
