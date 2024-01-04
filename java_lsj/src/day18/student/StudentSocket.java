package day18.student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentSocket extends Thread{
	@NonNull
	private Socket socket;
	@NonNull
	List<Student> list;
	
	private ObjectInputStream ois;//클라이언트에서 읽어오때 사용
	private ObjectOutputStream oos;//클라이언트에 보낼 때 사용
	
	public void run() {
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			while(true) {
				//클라이언트가 요청한 기능을 실행
				//클라이언트가 요청한 기능을 입력
				String menu = ois.readUTF();
				//요청한 기능을 실행 
				switch(menu) {
				case "LOAD":
					load();
					System.out.println(list);
					break;
				case "SAVE":
					//저장기능 실행
					save();
					return;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void load() {
		try {
			oos.writeObject(list);
			oos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void save() {
		String fileName = "src/teacher/day18/list.txt";
		try {
			ObjectOutputStream foos = 
				new ObjectOutputStream(new FileOutputStream(fileName));
			List<Student> std = (List<Student>)ois.readObject();
			list.addAll(std);
			foos.writeObject(list);
			foos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
