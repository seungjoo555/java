package day04;

public class StarEx3 {

	public static void main(String[] args) {
		/*     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 */

		char ch = '*';
		int rows = 10;
		
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= rows-i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print(ch);				
			}
			System.out.println();
		}
		
	}

}
