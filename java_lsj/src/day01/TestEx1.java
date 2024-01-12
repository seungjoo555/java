package day01;

public class TestEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char ch1 = "A";
		
		//char ch1 = 'A';
		//String ch1 = "A"; 
		
		Word wd = new Word();
		System.out.println(wd);
	}

}

class Word{
	String name = "abc";
	int num = 1;
	@Override
	public String toString() {
		return "Word [name=" + name + ", num=" + num + "]";
	}
	
}