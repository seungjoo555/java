package day06;

import java.util.Scanner;

public class AlphabetCountEx1 {

	public static void main(String[] args) {
		/* 단어를 입력받아 단어에 각 알파벳이 몇번 나왔는지 출력하는 코드
		 * 입력 : apple
		 * a : 1
		 * e : 1
		 * l : 1
		 * p : 2
		 */
		Scanner scan = new Scanner(System.in);
		//알파벳 배열
		int []alpha = new int[26];
		
		System.out.print("단어 입력 : ");
		String str = scan.next().toString();
		char []ch = new char[str.length()];
		
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
			alpha[ch[i]-97]++;
		}
		
		for(int i = 0; i < alpha.length; i++) {
			if(alpha[i] != 0) {
				System.out.println((char)(i+97) + " : " + alpha[i]);
			}
		}
		
		char ch2 = 'a';
		for(int count : alpha) {
			if(count != 0) {
				System.out.println(ch2 + " : " + count);
			}
			ch2++;
		}
		scan.close();
	}

}
