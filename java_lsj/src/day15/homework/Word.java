package day15.homework;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7166211807053272219L;
	private ArrayList<String> list;
}
