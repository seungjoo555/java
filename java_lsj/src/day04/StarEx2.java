package day04;

public class StarEx2 {

	public static void main(String[] args) {
		/* *
		 * **
		 * ***
		 * ****
		 * *****
		 */
		char ch = '*';
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(ch);
			}
			System.out.println();
		}
		
	}

}
