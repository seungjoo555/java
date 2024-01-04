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
	
	static List<Student> list;
	
	public static void main(String[] args) {
		String fileName = "src/day18/student/studentInfo.txt";
		int port = 5001;
		
		try(ServerSocket serverSocket = new ServerSocket(port)) {
			while(true) {
				Socket socket = serverSocket.accept();
				StudentSocket ss =  new StudentSocket(socket);
				load(fileName);
				ss.send(list);
				list = ss.receive();
				save(fileName);
			}
		} catch (Exception e) {
			System.out.println("서버 소켓 생성에서 예외 발생");
		}
	}
	
	private static void save(String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
			System.out.println("저장 완료");
		} catch (FileNotFoundException e) {
			//폴더 경로가 잘못된 경우
			System.out.println("지정된 위치에 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	}
	
	private static void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			list = ((ArrayList<Student>)ois.readObject());
			System.out.println("불러오기 성공");
		} catch (FileNotFoundException e) {
			System.out.println("지정된 위치에 파일을 찾을 수 없습니다.");
		} catch (Exception e) {
			System.out.println("불러오기에 실패 했습니다.");
		}
	}

}
