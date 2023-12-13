package day04;

public class MultipleTableEx1 {

	public static void main(String[] args) {
		/*
		 * 구구단 2단부터 9단까지 출력하는 코드를 작성하세요.
		 */
		
		for(int dan = 2; dan <= 9; dan++) {
			System.out.println(dan +"단");
			for(int i = 1; i <= 9; i++) {
				System.out.println(dan + "x" + i + " = " + (dan * i));
			}
		}
		
	}

}
