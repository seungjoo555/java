package community.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import community.dao.UserDAO;
import community.model.vo.Member;

public class UserServiceImp implements UserService{

private UserDAO userDao;
	
	public UserServiceImp() {
		String resource = "community/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			userDao = session.getMapper(UserDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertMember(Member member) {
		if(member == null) {
			return false;
		}
		return userDao.insertMember(member);
	}

	@Override
	public Member checkId(String id) {
		if(id == null) {
			return null;
		}
		return userDao.searchId(id);
	}

	@Override
	public List<Member> getRequestMember(String string) {
		return userDao.selectRequestMemberList(string);
	}

	@Override
	public void okeydokeyAllRequest() {
		userDao.updateAllRequestMember();
	}

	@Override
	public boolean okeydokeyRequest(String me_id) {
		return userDao.updateRequestMember(me_id);
	}

}
