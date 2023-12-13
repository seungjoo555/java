package day04;

public class StarEx1 {

	public static void main(String[] args) {
		/*
		 * *****
		 * *****
		 * *****
		 * 위와 같이 출력이 되도록 작성 해보세요.
		 */

		char ch = '*';
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}

}
