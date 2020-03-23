package spring.Assembler;

import spring.layer.memberLogic.ChangePasswordService;
import spring.layer.memberLogic.MemberRegisterService;
import spring.layer.memberStorage.MemberDAO;

public class Assembler {
	//
	private MemberDAO memberDAO;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	
	public Assembler() {
		memberDAO = MemberDAO.getInstance();
		memberRegisterService = new MemberRegisterService(memberDAO);
		changePasswordService = new ChangePasswordService(memberDAO);
	}
	
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}
	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}
	public ChangePasswordService getChangePasswordService() {
		return changePasswordService;
	}
}
