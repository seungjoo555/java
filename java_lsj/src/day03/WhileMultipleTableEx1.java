package day03;

public class WhileMultipleTableEx1 {

	public static void main(String[] args) {
		/*
		 * 구구단 2단을 출력하는 코드를 작서아세요.
		 * 2 x 1 = 2
		 * 2 x 2 = 4
		 * ...
		 * 2 x 9 = 18
		 */
		int dan = 2;
		int i = 1;
		
		while(i <= 9) {
			System.out.println(dan + " x " + i + " = " + (dan*i));
			i++;
		}
		
	}

}
