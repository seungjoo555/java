package day04;

public class PrimeNumberEx1 {

	public static void main(String[] args) {
		/* 2부터 100사이의 모든 소수를 출력하는 코드를 작성하세요.
		 * 소수 판별 예제 이용(3일차 : ForPrimeNumberEx1.java 참고)
		 */
		
		for(int i = 2; i <= 100; i++) {
			int pr = 0;
			for(int j = 2; j < i; j++) {
				if (i % j == 0) {
					pr = 1;
				}
			}
			if(pr == 0){
				System.out.print(i + " ");
			}
			
			
		}
		
	}

}
