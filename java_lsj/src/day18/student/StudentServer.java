package day18.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class StudentServer {
	
	private static List<Student> list;
	private static String fileName = "src/day18/student/studentInfo.txt";
	
	public static void main(String[] args) {
		int port = 5001;
		load();
		System.out.println(list);
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				Socket socket = serverSocket.accept();
				StudentSocket ss =  new StudentSocket(socket, list);
				ss.start();
			}
		} catch (Exception e) {
			System.out.println("서버 소켓 생성에서 예외 발생");
		}
	}
	
	private static void save() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.flush();
			System.out.println("저장 완료");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void load() {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = ((List<Student>)ois.readObject());
			System.out.println("불러오기 성공");
		} catch (IOException | ClassNotFoundException e) {
			list = new ArrayList<Student>();
			e.printStackTrace();
		}
	}

}
