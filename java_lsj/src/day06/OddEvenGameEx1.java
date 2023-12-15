package day06;

import java.util.Scanner;

public class OddEvenGameEx1 {

	public static void main(String[] args) {
		//정수 num이 주어졌을 때 홀수인지 짝수인지 판별하는 예제
		Scanner scan = new Scanner(System.in);
		int num = 10;
		int min = 1, max = 100;
		int user;
		int coin = 10000; //게임 시작시 주어지는 금액
		int usercoin = 0;
		//아래 코드를 현재 금액이 0이 될때까지 반복하도록 수정
		while(coin > 0) {
			//num이 1 - 100 사이의 랜덤한 수를 생성하는 코드를 작성
			num = (int)(Math.random() * (max - min + 1) + min);
			
			//사용자가 게임에 투입할 금액을 입력하는 코드를 작성(1~ 현재 금액까지)
			System.out.print("게임에 걸 판돈을 입력하세요(남은금액: " + coin + ") : ");
			usercoin = scan.nextInt();
			
			//입력받은 배팅금액이 총금액보다 크면 배팅금액을 총금액으로 수정
			if(usercoin > coin) {
				usercoin = coin;
				System.out.println("배팅금액이 변경되었습니다. 현재배팅금액 : " + usercoin);
			}else if(usercoin < 1) {
				usercoin = 1;
				System.out.println("1원 이하는 걸수 없습니다. 현재배팅금액 : " + usercoin);
			}
			
			//사용자가 0또는 1을 입력하는 코드를 작성 0:짝수, 1:홀수
			System.out.print("0:짝, 1:홀 : ");
			user = scan.nextInt();
			if(user < 0 || user > 1) {
				System.out.println("0또는 1을 입력해 주세요.");
				continue;
			}
			
			if(num % 2 == 0) {
				System.out.println(num + "는 짝수");
			}else {
				System.out.println(num + "는 홀수");			
			}
			
			//사용자가 입력한 값이 맞았는지 틀렸는지를 출력하는 코드를 작성
			//사용자가 입력한 값이 num의 홀짝과 맞는지를 출력하는 코드
			//승이면 배팅 금액을 주고, 패이면 배팅 금액을 차감
			if(num % 2 == user) {
				System.out.println("맞췄습니다.");
				coin += usercoin;
			}else {
				System.out.println("틀렸습니다.");
				coin -= usercoin;
			}
			
			System.out.println("현재 금액 : " + coin);
		}
		System.out.println("파산....");
		
		scan.close();
	}

}
