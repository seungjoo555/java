package day06;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/* 숫자 야구게임을 구현하세요.
		 * - 1~9사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
		 * - S : 숫자가 있고, 위치가 같은 경우
		 * - B : 숫자가 있지만 위치가 다른 경우
		 * - O : 일치하는 숫자가 하나도 없는 경우
		 * - 3S가 되면 게임이 종료
		 * 
		 * 예시
		 * 랜덤으로 생성된 숫자 : 3 9 1
		 * 입력 : 1 2 3
		 * 결과 : 2B
		 * 
		 * 입력 : 4 5 6
		 * 결과 : O
		 * 
		 * 입력 : 7 9 8
		 * 결과 : 1S
		 * 
		 * 입력 : 3 1 9
		 * 결과 : 1S 2B
		 * 
		 * 입력 : 3 9 1
		 * 결과 : 3S
		 * 정답입니다.
		 * 도전 횟수 : 5
		 * 현재 1등입니다. 이름을 기록하세요.
		 * 이름 : LSJ
		 * 
		 * 메뉴
		 * 1. 새게임
		 * 2. 기록확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 
		 * -- 기록 --
		 * 1. LSJ : 5회
		 */
		Scanner scan = new Scanner(System.in);
		
		int menu;
		int []r_Num = new int[3];
		int count = 0;	//배열에 저장된 중복되지 않은 수의 개수
		int []topScore = new int[6];
		String []name = new String[6];
		
		for(int i = 0; i < topScore.length; i++) {
			topScore[i] = 100;
		}
		
		do {
			int score = 0;
			System.out.println("***********************");
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			
			if(menu == 1) {
				// 랜덤 생성 숫자 3개 만들기
				while(count < r_Num.length) {
					int r = (int)(Math.random() * 9 + 1);
					
					int i;
					for(i = 0; i < count; i++) {
						if(r == r_Num[i]) {
							break;
						}
					}
					if(i == count) {
						r_Num[count++] = r;
					}
				}
				//	랜덤 숫자 테스트용
				for(int i = 0; i < 3; i++) {
					System.out.print(r_Num[i] + " ");
				}
				System.out.println();
				
					
					
					
				while(true){
					//사용자 입력 받기
					int []user = new int[3];
					count = 0;
					System.out.print("입력 : ");
					while(count < user.length) {
						int input = scan.nextInt();
						int i;
						for(i = 0; i < count; i++) {
							if(user[i] == input) {
								break;
							}
						}
						if(i == count) {
							user[count++] = input;
						}
					}
					score++;
					
					
					
					
					//S, B, O 판별
					int []SBO = new int[3];
					for(int i = 0; i < r_Num.length; i++) {
						for(int j = 0; j < user.length; j++) {
							if(r_Num[i] == user[i]) {
								SBO[0]++;	//총 9번 판별하기때문에 3으로 나눠야함
							}else if(r_Num[i] == user[j]) {
								SBO[1]++;
							}else {
								SBO[2]++;	//9가 되면 일치하는 번호가 없는것
							}
						}
					}
					
					
					
					//결과창
					System.out.print("결과 : ");
					if(SBO[2] == 9) {
						System.out.print("Out..");
					}else {
						for(int i = 0; i < SBO.length - 1; i++) {
							if(SBO[i] != 0) {
								if(i == 0) {
									System.out.print(SBO[i]/3);
									System.out.print("S ");
								}else {
									System.out.print(SBO[i]);
									System.out.print("B");
								}
							}
						}
					}
					System.out.println();
					
					//3S가 되면 게임 끝
					if(SBO[0] == 9) {
						System.out.println("도전 횟수 : " + score);
						if(topScore[0] > score) {
							topScore[5] = score;
							System.out.println("현재 1등입니다. 이름을 기록하세요.");
							System.out.print("이름 : ");
							name[5] = scan.next().toString();
						}
						for(int i = 0; i < topScore.length-1; i++) {
							for(int j = 0; j < topScore.length-(1+i); j++) {
								if(topScore[j] > topScore[j+1]) {
									int tmp = topScore[j];
									String tmp2 = name[j];
									topScore[j] = topScore[j+1];
									name[j] = name[j+1];
									topScore[j+1] = tmp;
									name[j+1] = tmp2;
								}
							}
						}
						break;
					}
				}
			}
			else if(menu == 2) {
				System.out.println(" -- 기록 -- ");
				for(int i = 0; i < 5; i++) {
					if(topScore[i] != 100) {
						System.out.println((i+1)+ ". " + name[i] + " : " + topScore[i] + "회");
					}
				}
			}
		}while(menu != 3);
		System.out.println("프로그램 종료");
		
		scan.close();
	}

}
