package day03;

public class WhileTestEx3 {

	public static void main(String[] args) {
		/*
		 * 1에서 10사이의 모든 짝수를 순서대로 출력하는 코드를 작성하세요.
		 * 2
		 * 4
		 * 6
		 * 8
		 * 10
		 */
		int i = 1;
		
		while(i <= 10) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		
		int j = 1;
		while(j <= 5) {
			System.out.println(j * 2);
			j++;
		}
		
		int k = 2;
		while(k <= 10) {
			System.out.println(k);
			k += 2;
		}
	}

}
