package day08;

import java.util.Scanner;

public class CarMain {

	public static void main(String[] args) {
		/* Scanner : 클래스명
		 * scan : 인스턴스명
		 * Scanner(System.in) : 표준 입력을 이용하여 초기화 하는 생성자
		 * Scanner("123\nabc") : 문자열을 이용하여 초기화 하는 생성자
		 */
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner("123\nabc");
		
		/* Car : 클래스명
		 * car01 : 인스턴스명
		 * new : 인스턴스를 생성하는 연산자
		 * Car() : 생성자
		 */
		Car car01 = new Car();
		car01.OnOff();			//시동켜기
		car01.print();
		car01.turnLight(-1);	//좌측 깜빡이 켜기
		car01.print();
		car01.turnLight(1);		//우측 깜빡이 켜기
		car01.print();
		car01.turnLight(0);		//깜빡이 끄기
		car01.print();
		car01.speedUp(10);			
		car01.print();
		car01.speedDown(10);			
		car01.print();
		
		
		
		
		
		scan.close();
		scan2.close();
	}

}
