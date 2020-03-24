package spring.layer.memberLogic;

import org.springframework.beans.factory.annotation.Autowired;

import spring.entity.Member;
import spring.layer.memberStorage.MemberDAO;
import spring.util.MemberNotFoundException;

public class PrintSingleMemberService {
	//
	@Autowired
	private MemberDAO memberDAO;
	
	public Member findMember(String email) {
		Member foundMember = memberDAO.selectByEmail(email);
		if(foundMember == null) {
			throw new MemberNotFoundException("No such member using the email -> "+email);
		}
		
		return foundMember;
	}
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
}
