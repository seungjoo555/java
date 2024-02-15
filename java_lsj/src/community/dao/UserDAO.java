package community.dao;

import org.apache.ibatis.annotations.Param;

import community.model.vo.Member;

public interface UserDAO {

	public boolean insertMember(@Param("member")Member member);

}
