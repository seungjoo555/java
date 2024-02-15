package community.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	String me_id;			//아이디
	String me_pw;			//비밀번호
	String me_email;		//이메일
	String me_authority;	//유저권한
	String me_name;			//이름
	String me_phoneNum;		//전화번호
	String me_address;			//주소
	
	public Member(String id, String pwd, String email, String name, String phone, String addr) {
		me_id = id;
		me_pw = pwd;
		me_email = email;
		me_name = name;
		me_phoneNum = phone;
		me_address = addr;
	}
	
	
	
	
	
	
	
	
}
