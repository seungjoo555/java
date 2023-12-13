package day04;

public class StarEx4 {

	public static void main(String[] args) {
		/*
		 *     *
		 *    ***
		 *   *****
		 *  *******
		 * *********
		 */

		char ch = '*';
		int rows = 10;
		
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= rows-i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= (i * 2 - 1); k++) {
				System.out.print(ch);				
			}
			System.out.println();
		}
		
		//------------------------------------------------
		
		/*
		 *     *
		 *    ** *
		 *   *** **
		 *  **** ***
		 * ***** ****
		 */
		
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= rows-i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print(ch);				
			}
			for(int k = 1; k <= i - 1; k++) {
				System.out.print(ch);				
			}
			System.out.println();
		}
		
	}

}
