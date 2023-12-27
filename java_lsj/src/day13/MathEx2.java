package day13;

public class MathEx2 {

	public static void main(String[] args) {
		//주어진 실수의 소수점 3자리에서 올림한 값을 출력하는 코드를 작성하세요.
		double num = 1.234567;
		num = num * Math.pow(10,2);
		num = Math.ceil(num);
		num = num / Math.pow(10,2);
		System.out.println("소수점 3자리 올림 : " + num);
		System.out.println();
		
		//주어진 실수의 소수점 n자리에서 올림한 값을 울력하는 코드를 작성하세요.
		int n = 5;
		double num2 = 1.234567;
		num2 = num2 * Math.pow(10,n-1);
		num2 = Math.ceil(num2);
		num2 = num2 / Math.pow(10,n-1);
		System.out.println("소수점 " + n + "자리 올림 : " + num2);
	}

}
