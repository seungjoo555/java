package day03;

import java.util.Scanner;

public class ForUpDownEx1 {

	public static void main(String[] args) {
		/*
		 * 숫자 업다운 게임을 작성하세요.
		 */
		try (Scanner scan = new Scanner(System.in)) {
			int min = -10, max = 100;
			int ran = (int)(Math.random() * (max-min+1) + min);
			int num = min - 1;
			
			for( ; ran != num ; ) {
				System.out.print("(" +min+ "~"+ max + ")" + "사이의 숫자 입력 : ");
				num = scan.nextInt();
				if(num < min || num > max) {
					System.out.println("(" +min+ "~"+ max + ")" + "사이의 숫자를 입력해 주세요.");
				}else if(num < ran) {
					System.out.println("Up");
				}else if(num > ran) {
					System.out.println("Down");
				}else {
					System.out.println("정답");
				}
			}
			scan.close();
		}
	}

}
