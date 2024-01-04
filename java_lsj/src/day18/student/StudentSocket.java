package day18.student;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class StudentSocket {
	private Socket socket;
	List<Student> list = new ArrayList<Student>();
	
	public List<Student> receive() {
		Thread t = new Thread(()->{
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(socket.getInputStream());
				while(true) {
					list = (List<Student>)ois.readObject();
					break;
				}
				System.out.println(list);
			} catch (Exception e) {
				System.out.println("예외 발생 읽기 기능 종료");
			}
		});
		t.start();
		return list;
	}
	
	public void send(List<Student> list) {
		Thread t = new Thread(()->{
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(socket.getOutputStream());
				while(true) {
					oos.writeObject(list);
					oos.flush();
					System.out.println("전송 완료");
					break;
				}
			} catch (Exception e) {
				System.out.println("예외 발생 전송 기능 종료");
			}
		});
		t.start();
	}
	
	public StudentSocket(Socket socket) {
		this.socket = socket;
	}
	
}
