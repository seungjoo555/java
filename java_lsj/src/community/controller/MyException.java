package community.controller;

import lombok.Data;

@Data
public class MyException extends Exception{

	private String alert;
	
	public MyException () {}
	
	public MyException(String alert) {
		this.alert = alert;
	}
	
}
