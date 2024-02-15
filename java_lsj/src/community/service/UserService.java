package community.service;

import community.model.vo.Member;

public interface UserService {

	boolean insertMember(Member member);

	boolean checkId(String id);

	boolean checkPwd(String pwd);

	Member getMember(String id, String pwd);

}
