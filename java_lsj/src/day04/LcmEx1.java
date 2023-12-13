package day04;

public class LcmEx1 {

	public static void main(String[] args) {
		/*
		 * 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 * 10의 배수 : 10, 20, 30, ...
		 * 15의 배수 : 15, 30, 45, ...
		 * 10과 15의 공배수 : 30, 60, 90, ...
		 * 10과 15의 최소 공배수 : 30
		 */

		
		int num3 = 10, num4 = 15;
		int num5 = 0, num6 = 0;
		
		System.out.print(num3+", "+num4+"의 최소 공배수: ");
		Loop1 :
		for(int i = 1; i <= num4; i++) {
			num5 = num3*i;
			for(int j = 1; j <= num3; j++) {
				num6 = num4*j;
				if(num5 == num6) {
					System.out.println(num5);
					break Loop1;
				}
			}
		}
		
		
		//-------------------------------------------------------------
		int num1 = 10, num2 = 15;
		for(int i = 1; i <= num1*num2; i++) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(i);
				break;
			}
		}
		
		//---------------------------------------------------
		for(int i = num1; i <= num1*num2; i+=num1) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(i);
				break;
			}
		}
		
		
		
	}

}
