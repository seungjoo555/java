package day05;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx2 {

	public static void main(String[] args) {
		/* 로또 당첨 번호를 랜덤으로 생성한 후(당첨번호 6자리 + 보너스번호)
		 * 사용자가 로또번호를 입력하면(로또번호 6자리) 당첨 등수를 출력하는 코드를 작성하세요.
		 */
		
		Scanner scan = new Scanner(System.in);
		
		//로또 번호
		int min = 1, max = 45;
		int lotto[] = new int[6];
		int bonus = (int)(Math.random() * (max-min+1) + min);
		int count = 0;	//배열에 저장된 중복되지 않은 수의 개수
		
		while(count < lotto.length) {
			//랜덤수 생성
			int ran = (int)(Math.random() * (max-min+1) + min);
			//중복 확인
			boolean duplicated = false;		//중복 여부를 알려주는 변수로, true 중복, false 중복아님
			for(int i = 0; i < count; i++) {
				if(lotto[i] == ran || bonus == ran) {
					duplicated = true;
					break;
				}
			}
			//중복되지 않으면 저장 후 count 증가
			if(!duplicated) {
				lotto[count] = ran;
				count++;
			}			
		}
		
		//당첨번호 확인용
		System.out.print("당첨 번호 : ");
		for(int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println("+ " + bonus);
		
		//복권 번호 입력하기
		int num[] = new int[6];
		int count2 = 0;
		
		while(count2 < num.length) {
			System.out.print((count2+1) + "번째 번호 입력 : ");
			int usernum = scan.nextInt();
			if(usernum < 1 || usernum > 45) {
				System.out.println("범위를 벗어났습니다. 다시 입력해 주세요.");
				continue;
			}
			//중복 확인
			boolean duplicated = false;		//중복 여부를 알려주는 변수로, true 중복, false 중복아님
			for(int j = 0; j < count2; j++) {
				if(num[j] == usernum) {
					duplicated = true;
					break;
				}
			}
			//중복되지 않으면 저장 후 count 증가
			if(!duplicated) {
				num[count2] = usernum;
				count2++;
			}else {
				System.out.println("중복 번호입니다. 다시 입력해 주세요.");
				continue;
			}
		}
		
		Arrays.sort(num);
		Arrays.sort(lotto);

		System.out.print("선택 번호 : ");
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.print("\n당첨 번호 : ");
		for(int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println(" + " + bonus);
		
		int good = 0;
		for (int k = 0; k < num.length; k++) {
			for(int l = 0; l < lotto.length; l++) {
				if(num[k] == lotto[l]) {
					good++;
				}				
			}
		}
		
		lop:
		switch(good) {
		case 6:
			System.out.println(good + "개 맞췄습니다. 1등 당첨!");
			break;
		case 5:
			for(int o = 0; o < 6; o++) {
				if(num[o] == bonus) {
					System.out.println(good + "개에 보너스번호까지. 2등 당첨!");
					break lop;
				}
			}
			System.out.println(good + "개 맞췄습니다. 3등!");
			break;
		case 4:
			System.out.println(good + "개 맞췄습니다. 4등");
			break;
		case 3:
			System.out.println(good + "개 맞췄습니다. 5등");
			break;
		default:
			System.out.println(good + "개 맞췄습니다. 꽝...");
		}
		
		
	}

}
