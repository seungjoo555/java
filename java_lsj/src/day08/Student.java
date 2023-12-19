package day08;

/* 학생의 국어, 영어, 수학 성적을 관리하기 위한 프로그램을 작성하려고 한다.
 * 이 때 필요한 학생 클래스를 생성해보세요.
 */
public class Student {
	//멤버변수
	//국어, 영어, 수학 성적
	//학생번호, 학년, 반, 이름
	int kor, eng, math;
	int grade, classNum, num;
	String name;
	
	
	//메서드
	//학생 정보확인, 학생 성적확인
	//국어, 영어, 수학 성적수정
	
	/* 기능 : 학생 정보(학년, 반, 번호, 이름)을 콘솔에 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메서드명 : printInfo
	 */
	public void printInfo() {
		System.out.println("--------------------");
		System.out.println("학년 : " + grade);
		System.out.println("반 : " + classNum);
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("--------------------");
	}
	
	/* 기능 : 학생 성적(학년, 반, 번호, 이름, 국어, 영어, 수학)을 콘솔에 출력하는 메서드
	* 매개변수 : 
	* 리턴타입 : 
	* 메서드명 : printScore
	*/
	public void printScore() {
		printInfo();
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.println("--------------------");
	}
	
	/* 기능 : 국어 성적을 수정하는 메서드
	 * 매개변수 : 수정하려는 국어 성적 => int s_kor
	 * 리턴타입 : 없음 void
	 * 메서드명 : setKor
	 */
	public void setKor(int s_kor) {
		kor = s_kor;
	}
	
	/* 기능 : 영어 성적을 수정하는 메서드
	 * 매개변수 : 수정하려는 영어 성적 => int s_eng
	 * 리턴타입 : void
	 * 메서드명 : setEng
	 */
	public void setEng(int s_eng) {
		eng = s_eng;
	}
	
	/* 기능 : 수학 성적을 수정하는 메서드
	 * 매개변수 : 수정하려는 수학 성적 => int s_math
	 * 리턴타입 : void
	 * 메서드명 : setMath
	 */
	//성적 출력
	public void setMath(int s_math) {
		math = s_math;
	}
		
}
