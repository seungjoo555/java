package day08;

public class Car {
	/* - 정보 : 멤버변수
	 * - 무게(단위는 톤), 브랜드, 분류, 색상, 바퀴, 차 이름, 연식
	 */
	double weight;
	String brand;
	//0: 소형, 1:중형, 2:대형, 3:화물, 4:세단
	//int category;		//정수로도 차를 분류가능
	String category;
	//0xff0000
	//int color:
	String color;
	String [] tires;
	String carName;
	int year;
	boolean power;		//시동이 켜졌는지 꺼졌는지 확인하기 위한 멤버변수
	int speed;			//현재 속력
	boolean l_Light;	//좌측 깜빡이
	boolean r_Light;	//우측 깜빡이
	
	
	/* - 기능 : 메서드
	 * - 가속(엑셀), 감속(브레이크), 시동 켜기/끄기
	 * - 좌측|우측 깜빡이를 켜기/끄기
	 */
	//시동을 켜기/끄기
	//시동이 꺼져있으면 켜고, 시동이 켜져있으면 꺼짐
	public void OnOff() {
		power = !power;
		if(power) {
			System.out.println("시동이 켜졌습니다.");
		}else {
			System.out.println("시동이 꺼졌습니다.");			
		}
	}
	
	//가속
	public void speedUp(int sp) {
		for(int i = 0; i < sp; i++) {
			speed++;
		}
	}
	//감속
	public void speedDown(int sp) {
		for(int i = 0; i < sp; i++) {
			speed--;
		}	
	}
	
	//좌측|우측 깜빡이 켜기/끄기 (위(우측1), 가운데0, 아래(좌측-1))
	public void turnLight(int direction) {
		switch(direction) {
		case 1:	r_Light = true; l_Light = false; break;
		case 0: r_Light = false; l_Light = false; break;
		case -1: r_Light = false; l_Light = true; break;
		}
	}
	
	//자동차 현재 상태를 출력하는 메서드
	public void print() {
		System.out.println("---------------------------");
		System.out.println("시동 : " + power);
		System.out.println("속력 : " + speed);
		System.out.println("좌깜: " + l_Light);
		System.out.println("우깜: " + r_Light);
		System.out.println("---------------------------");
	}
}
