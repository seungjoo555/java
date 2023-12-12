package day03;

public class WhileSumEx1 {

	public static void main(String[] args) {
		/*
		 * 1부터 5까지의 합을 구하는 코드를 작성하세요.
		 */
		int i = 1;
		int sum = 0;
		int num = 5;
		
		
		while(i <= num) {
			sum += i;
			i++;
		}
		System.out.println("1 부터 " + num + " 까지의 합은 : " + sum);
	}

}
