package day03;

public class WhileTestEx2 {

	public static void main(String[] args) {
		/*
		 * 5부터 1까지 거꾸로 출력하는 코드를 작성하세요.
		 * 5
		 * 4
		 * 3
		 * 2
		 * 1
		 */
		int num = 5;
		
		while(num >= 1) {
			System.out.println(num);
			num--;
		}
	}

}
