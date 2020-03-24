package spring.layer.memberLogic;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dto.RegisterRequest;
import spring.entity.Member;
import spring.layer.memberStorage.MemberDAO;
import spring.util.DuplicateMemberException;

public class MemberRegisterService {
	//
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberRegisterService() {
		//
	}
	
	public Long register(RegisterRequest registerRequest) {
		//
		Member member = memberDAO.selectByEmail(registerRequest.getEmail());
		
		if(member != null)
			throw new DuplicateMemberException("The member email already exist -> "+registerRequest.getEmail());
		
		Member newMember = new Member(registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getName(), LocalDateTime.now());
		
		memberDAO.insert(newMember);//해당 newMember객체의 주소값으로 전달하기 때문에 insert()내의 setId()가 적용된다.
		
		return newMember.getId();
	}
}
