package spring.layer.memberLogic;

import java.util.Collection;

import spring.entity.Member;
import spring.layer.memberStorage.MemberDAO;
import spring.util.MemberPrinter;

public class PrintEntireMemberService {
	//
	private MemberDAO memberDAO;
	
	public PrintEntireMemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public Collection<Member> findAll() {
		return memberDAO.selectAll();
	}
}
