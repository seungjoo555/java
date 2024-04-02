package kr.kh.spring3.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {

	private String me_id;
	private String me_pw;
}
