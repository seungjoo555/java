package day01;

public class VariableEx4 {

	//논리형 변수 선언 예제
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isEven = true;
		System.out.println(isEven);
		
		// 논리형 변수가 사용되는 방식을 보여주는 예제
		isEven = 3 % 2 == 0;
		System.out.println("2 is Even number? " + isEven);
	}

}
