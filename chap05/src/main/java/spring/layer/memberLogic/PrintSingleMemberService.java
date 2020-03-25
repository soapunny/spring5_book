package spring.layer.memberLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.entity.Member;
import spring.layer.memberStorage.MemberDAO;
import spring.util.MemberNotFoundException;

@Component("infoPrinter")
public class PrintSingleMemberService {
	//
	private MemberDAO memberDAO;
	
	public Member findMember(String email) {
		Member foundMember = memberDAO.selectByEmail(email);
		if(foundMember == null) {
			throw new MemberNotFoundException("No such member using the email -> "+email);
		}
		
		return foundMember;
	}

	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
}
