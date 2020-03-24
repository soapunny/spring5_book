package spring.layer.memberLogic;

import org.springframework.beans.factory.annotation.Autowired;

import spring.entity.Member;
import spring.layer.memberStorage.MemberDAO;
import spring.util.MemberNotFoundException;

public class ChangePasswordService {
	//
	@Autowired
	private MemberDAO memberDAO;
	
	public void changePassword(String email, String oldPassword, String newPassword) {
		//
		Member member = memberDAO.selectByEmail(email);
		
		if(member == null)
			throw new MemberNotFoundException("There is no member using the email -> "+email);
		
		member.changePassword(oldPassword, newPassword);
		
		memberDAO.update(member);
	}
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
}
