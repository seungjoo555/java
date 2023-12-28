package day14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoEx2 {

	public static void main(String[] args) {
		/* 랜덤으로 당첨 번호를 생성하고, 사용자가 로또 번호를 입력하면 등수를 알려주는 코드를 작성하세요
		 * 단, 컬렉션을 이용
		 * 당첨번호 : 6개, 보너스 : 1개
		 * 사용자 : 6개
		 */
		//중복되지 않은 세 수를 저장하는 예제 : 1~9
		Scanner scan = new Scanner(System.in);
		
		//랜덤 번호 7개 만들 set 생성
		Set<Integer> set = new HashSet<Integer>();
		//생성한 랜덤번호 옮길 리스트 생성
		List<Integer> com = new ArrayList<Integer>();
		//고른 번호 저장할 리스트 생성
		List<Integer> user = new ArrayList<Integer>();
		//당첨된 번호의 개수 카운트
		int count = 0;
		//랜덤 번호 범위
		int min = 1, max = 45;
		//set의 크기에 맞게 랜덤번호 추가(set은 중복x)
		while(set.size() < 7) {
			Random random = new Random();
			int tmp = random.nextInt(max - min + 1) + min;
			set.add(tmp);
		}
		
		//리스트인 com에 요소를 복사
		com.clear();
		com.addAll(set);
		//마지막 번호를 리스트에서 삭제하면서 반환된 요소를 보너스에 저장
		int bonus = com.remove(6);
		System.out.println(set);
		System.out.println(com);
		System.out.println(bonus);
		System.out.println(com + ", 보너스 : " + bonus);
		
		
		System.out.print("번호 6개 : ");
		for(int i = 0; i < 6; i++) {
			int num = scan.nextInt();
			user.add(num);
		}
		
		System.out.println(user);
		
		for(int tmp : user) {
			if(com.contains(tmp)) {
				count++;
			}
		}
		
		switch(count) {
		case 6:
			System.out.println("1등");
			break;
		case 5:
			int rank = user.contains(bonus) ? 2 : 3;
			System.out.println(rank + "등");
			break;
		case 4:
			System.out.println("4등");
			break;
		case 3:
			System.out.println("5등");
			break;	
		default:
			System.out.println("꽝");
		}
		
		scan.close();
	}

}
