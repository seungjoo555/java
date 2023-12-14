package day05;

public class ArrayInitEx1 {

	//배열 예제
	public static void main(String[] args) {
		//aar1배열에는 0번지부터 4번지까지 모두 0으로 초기화가 됨
		//char는 \0, 정수는 0, 실수는 0.0, boolean는 false
		int arr1[] = new int[5];
		
		//aar2는 0번지에1, 1번지에 2, 2번지에 3, ....4번지에 5가 저장
		//aar2는 총 5개의 크기를 가진 배열이 됨
		int arr2[] = new int[] {1, 2, 3, 4, 5};
		arr2 = new int[] {3, 4, 5, 6, 7};
		
		//aar3은 aar2와 같음
		//단, aar3와 같이 초기화 하는 경우는 배열선언과 동시에 초기화 하는 경우만 가능
		int arr3[] = {1, 2, 3, 4, 5};
		//arr3 = {4, 6, 7, 8, 8};	//에러 발생
	}

}
