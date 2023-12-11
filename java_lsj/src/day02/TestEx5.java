package day02;

import java.util.Scanner;

public class TestEx5 {

	public static void main(String[] args) {
		/*
		 * 월을 입력받아 입력받은 월의 계절을 출력하세요.
		 * 3,4,5 : 봄
		 * 6,7,8 : 여름
		 * 9,10,11 : 가을
		 * 12, 1, 2 : 겨울
		 */
		Scanner scan = new Scanner(System.in);
		/*
		while(true) {
			System.out.print("월을 입력하세요(종료 하려면 0) : ");
			int month = scan.nextInt();
			
			if(month == 0) {
				System.out.println("종료");
				break;
			}else if(month >= 3 && month <= 5) {
				System.out.println("봄");
				continue;
			}else if(month >= 6 && month <= 8) {
				System.out.println("여름");
				continue;
			}else if(month >= 9 && month <= 11) {
				System.out.println("가을");
				continue;
			}else if(month >=1 && month <= 2 || month == 12) {
				System.out.println("겨울");
				continue;
			}else {
				System.out.println("다시 입력해 주세요.");
				continue;
			}
		}
		*/
		while(true) {
			System.out.print("월을 입력하세요(종료 하려면 0) : ");
			int month = scan.nextInt();
			
			if(month == 0) {
				System.out.println("종료");
				break;
			}else if(month < 1 || month > 12) {
				System.out.println("다시 입력해 주세요.");
				continue;
			}else if(month <= 2 || month == 12) {
				System.out.println("겨울");
				continue;
			}else if(month <= 5) {
				System.out.println("봄");
				continue;
			}else if(month <= 8) {
				System.out.println("여름");
				continue;
			}else {
				System.out.println("가을");
				continue;
			}
		}
		scan.close();
	}

}
