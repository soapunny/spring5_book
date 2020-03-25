package spring.layer.memberLogic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.entity.Member;
import spring.layer.memberStorage.MemberDAO;

@Component("listPrinter")
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
