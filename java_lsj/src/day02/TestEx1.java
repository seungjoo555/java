package day02;

public class TestEx1 {

	// 연산자 예제 테스트
	public static void main(String[] args) {
		/* 다음 코드를 이용하여 국어, 영어, 수학 성적의 평균을 구하여 콘솔에 출력하는 코드를 작성 */
		int korScore = 100, engScore = 50, mathScore = 92;
		int sum = korScore + engScore + mathScore;
		double evg;
		evg = (double)sum / 3.0;
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + evg);
		
		/*
		 * 증감
		 * - 최종적으로 1증가/ 감소
		 * - 위치에 따라 전위/후위형
		 * 
		 * 비교연산자
		 * - 크기비교
		 * - 결과가 참/거짓
		 * - >=, <= 연산자 순서
		 * 
		 * 논리연산자
		 * - 결과가 참/거짓
		 * - && : ~이고
		 * - || : ~이거나
		 * - !  : 반대
		 * 
		 * 복합대입연산자
		 * - 연산자 줄여쓰기
		 * 
		 * 조건연산자
		 * - 조건문을 대체
		 * - 코드를 간결하게 쓸 수 있다
		 * 
		 * 비트연산자
		 * - 비트로 나열해서 논리연산
		 * 
		 * 비트이동연산자
		 * - 비트로 나열해서 왼쪽/오른쪽으로 비트들을 이동
		 * 
		 * 연산자 우선순위
		 * - 괄호가 가장 높다
		 */
	}

}
