package day08;

public class StudentMain {

	public static void main(String[] args) {
		//학생 1명의 정보를 저장하는 인스턴스를 생성해보세요.
		Student student = new Student();
		//1학년 1반 1번 홍길동
		student.grade = 1;
		student.classNum = 1;
		student.num = 1;
		student.name = "Hong Gil Dong";
		
		student.printInfo();
		//국어 : 90, 영어 : 100, 수학 : 80
		student.setKor(90);
		student.setEng(100);
		student.setMath(80);
		
		student.printScore();
	}

}
