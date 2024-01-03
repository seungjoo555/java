package day15.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class StringEx2 {

	private static Scanner scan = new Scanner(System.in);
	private static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	public static void main(String[] args) {
		String fileName = "src/day15/homework/wordInfo.txt";
		
		int menu = 0;
		load(fileName);
		//반복
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//메뉼 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != 8);
		save(fileName);
	}
	
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.단어 추가");
		System.out.println("2.단어 수정");
		System.out.println("3.단어 삭제");
		System.out.println("4.뜻 추가");
		System.out.println("5.뜻 수정");
		System.out.println("6.뜻 삭제");
		System.out.println("7.조회");
		System.out.println("8.종료");
		System.out.print("메뉴 선택 : ");
	}

	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//단어 추가
			ArrayList<String> list = new ArrayList<String>();
			System.out.print("추가할 단어 : ");
			String word = scan.next();
			if(map.containsKey(word)){
				System.out.println("이미 있는 단어");
			}else {
				map.put(word, list);
			}
			break;
		case 2:
			//단어 수정
			System.out.print("수정할 단어 : ");
			word = scan.next();
			if(map.containsKey(word)){
				System.out.print(word + " >> (단어수정) : ");
				String chWord = scan.next();
				map.put(chWord, map.remove(word));
			}else {
				System.out.println("없는 단어 입니다.");
			}
			break;
		case 3:
			System.out.print("삭제할 단어 : ");
			word = scan.next();
			if(map.containsKey(word)){
				map.remove(word);
			}else {
				System.out.println("없는 단어 입니다.");
			}
			//단어 삭제
			break;
		case 4:
			//뜻 추가
			System.out.print("뜻을 추가할 단어 : ");
			word = scan.next();
			if(map.containsKey(word)) {
				System.out.print("추가할 뜻 : ");
				String mean = scan.next();
				map.get(word).add(mean);
			}else {
				System.out.println("없는 단어");
			}
			break;
		case 5:
			//뜻 수정
			break;
		case 6:
			//뜻 삭제
			System.out.print("뜻을 삭제할 단어 : ");
			word = scan.next();
			if(map.containsKey(word)) {
				System.out.print("삭제할 뜻 : ");
				String mean = scan.next();
				if(map.get(word).remove(mean)) {
					System.out.println("뜻 : " + mean + "을 삭제 했습니다.");
				} else {
					System.out.println("뜻이 없습니다.");
				}
			}else {
				System.out.println("없는 단어");
			}
			break;
		case 7:
			//조회
			System.out.println(map);
			break;
		case 8:
			//종료
			System.out.println("종료");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	public static void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			map = (HashMap<String, ArrayList<String>>)ois.readObject();
			System.out.println("단어장을 불러왔습니다.");
		} catch (Exception e) {
			System.out.println("불러오기에 실패 했습니다.");
		}
	}
	
	public static void save(String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(map);
			System.out.println("단어장 저장 완료");
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	}
}
