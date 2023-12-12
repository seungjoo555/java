package day03;

public class ForEx2 {

	public static void main(String[] args) {
		/*
		 * 1에서 10사이의 짝수들의 합을 구하는 코드를 작성하세요.
		 */
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("1부터 10사이 짝수의 합 : " + sum);
		
		
		int sum2 = 0;
		for(int i = 1; i <= 5; i++) {
			sum2 += (i * 2);
		}
		System.out.println("1부터 10사이 짝수의 합 : " + sum2);
		
		
		int sum3 = 0;
		for(int i = 2; i <= 10; i += 2) {
			sum3 += i;
		}
		System.out.println("1부터 10사이 짝수의 합 : " + sum3);
	}

}
