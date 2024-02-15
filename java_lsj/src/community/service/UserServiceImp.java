package community.service;

import java.io.IOException;
import java.io.InputStream;

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
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkPwd(String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member getMember(String id, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}
}
