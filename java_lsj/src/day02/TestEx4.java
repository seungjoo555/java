package day02;

import java.util.Scanner;

public class TestEx4 {

	public static void main(String[] args) {
		//성인 판별 예제
		//나이를 입력받아 나이가 20세 이상이면 성인을 출력하고,
		//20세 미만이면 미성년자로 출력하는 코드를 작성하세요.
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("나이를 입력하세요 : ");
			int age = scan.nextInt();
			
			if(age < 0) {
				System.out.println("다시 입력해 주세요.");
				continue;
			}else if(age >= 20) {			
				System.out.println("성인 입니다.");
				break;
			}
			else {
				System.out.println("미성년자 입니다.");
				break;
			}
		}
		scan.close();
	}

}
