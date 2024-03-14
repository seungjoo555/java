package kr.kh.community.model.vo;

public class StudentVO {

	private int student_number;
	private String student_name; 
	private int korean_score; 
	private int english_score; 
	private int math_score;
	
	public int getStudent_number() {
		return student_number;
	}
	public void setStudent_number(int student_number) {
		this.student_number = student_number;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getKorean_score() {
		return korean_score;
	}
	public void setKorean_score(int korean_score) {
		this.korean_score = korean_score;
	}
	public int getEnglish_score() {
		return english_score;
	}
	public void setEnglish_score(int english_score) {
		this.english_score = english_score;
	}
	public int getMath_score() {
		return math_score;
	}
	public void setMath_score(int math_score) {
		this.math_score = math_score;
	}
	
	public StudentVO() {}
}
