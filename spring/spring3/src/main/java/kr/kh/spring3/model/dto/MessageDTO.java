package kr.kh.spring3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
	
	private String to;
	private String from;
	private String msg;
	
	
}