package spring.layer.memberLogic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import spring.entity.Member;
import spring.layer.memberStorage.MemberDAO;

public class PrintEntireMemberService {
	//
	private MemberDAO memberDAO;
	
	public PrintEntireMemberService() {
		//
	}
	
	public Collection<Member> findAll() {
		return memberDAO.selectAll();
	}
	
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
}
