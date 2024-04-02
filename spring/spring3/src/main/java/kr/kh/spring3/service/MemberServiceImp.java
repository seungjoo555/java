package kr.kh.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.MemberDAO;
import kr.kh.spring3.model.dto.LoginDTO;
import kr.kh.spring3.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	//문자열이 있으면 true 없으면 false를 반환
	private boolean checkString(String str) {
		return str != null && str.length() != 0;
	}
	
	@Override
	public int getMemberCount() {
		return memberDao.selectMemberCount();
	}


	@Override
	public boolean insertMember(MemberVO member) {
		//null체크
		if(member == null) {
			return false;
		}
		//아이디 중복체크를 위해서 아이디로 회원정보 가져오기
		MemberVO dbMember = memberDao.getMember(member.getMe_id());
		//있으면 false 리턴
		if(dbMember != null) {
			return false;
		}
		if(!checkString(member.getMe_pw())) {
			return false;
		}
		//비밀번호 암호화 설정
		//기존 비번 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		//암호화 한 비번 업데이트
		member.setMe_pw(encPw);
		
		try {
			//다오에게 회원가입 시키기
			return memberDao.insertMember(member);
		}catch(Exception e) {
			//이메일이 없으면 예외 발생
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MemberVO getMember(LoginDTO loginDto) {
		if(loginDto == null ||
			!checkString(loginDto.getMe_id())||
			!checkString(loginDto.getMe_pw())) {
			return null;
		}
		MemberVO user = memberDao.getMember(loginDto.getMe_id());
		if(user == null) {
			return null;
		}
		if(!passwordEncoder.matches(loginDto.getMe_pw(), user.getMe_pw())) {
			return null;
		}
		return user;
	}

}
