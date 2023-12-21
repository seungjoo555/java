package day10.word;

public class Word2 {
	private String word, meaning;
	
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getMeaning() {
		return meaning;
	}
	
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	public void printInfo() {
		System.out.println(word + " : " + meaning);
	}
	
	public void update(String meaning) {
		this.meaning = meaning;
	}
	
	/**단어가 주어지면 주어진 단어와 내 단어가 같은지 다른지를 알려주는 메서드
	 * @param word 같은지 다를지를 확인할 단어
	 * @return 주어진 word와 내 word가 같으면 true, 다르면 false 리턴
	 */
	public boolean equals(String word) {
		return word.equals(word);
	}
	
	//주어진 단어와 뜻으로 단어와 듯을 초기화 하는 생성자
	public Word2(String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
	}
	
}
