package day10.word;

public class Word {
	private static int count = 0;
	private int num;
	private String eng, kor;
	
	
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Word.count = count;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	
	public void printInfo() {
		System.out.print(num + ". ");
		System.out.print(eng + " ");
		System.out.print(kor + "\n");
	}
	
	public void update(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}
	
	/**단어가 주어지면 주어진 단어와 내 단어가 같은지 다른지를 알려주는 메서드
	 * @param word 같은지 다를지를 확인할 단어
	 * @return 주어진 word와 내 word가 같으면 true, 다르면 false 리턴
	 */
	public boolean equals(String word) {
		return this.eng.equals(word);
	}
	
	public Word(String eng, String kor) {
		this.num = ++count;
		this.eng = eng;
		this.kor = kor;
	}
	
}
