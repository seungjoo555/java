package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	
	String me_id;
	String me_ms_state;
	String me_pw;
	String me_email;
	String me_authority;
	String me_stop;
	int me_fail;
	String me_cookie;
	String me_cookie_limit;
	private boolean autoLogin;
	
}
