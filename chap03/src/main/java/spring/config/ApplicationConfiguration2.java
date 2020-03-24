package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import spring.layer.memberLogic.ChangePasswordService;
import spring.layer.memberLogic.MemberRegisterService;
import spring.layer.memberLogic.PrintEntireMemberService;
import spring.layer.memberLogic.PrintSingleMemberService;
import spring.layer.memberStorage.MemberDAO;

public class ApplicationConfiguration2 {
	//
	@Autowired
	private MemberDAO memberDAO;
	
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberDAO);
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {
		return new ChangePasswordService(memberDAO);
	}
	
	@Bean
	public PrintEntireMemberService printEntireMemberService() {//Constructor DI method
		return new PrintEntireMemberService(memberDAO);
	}
	
	@Bean
	public PrintSingleMemberService printSingleMemberService() {//Setter DI method
		PrintSingleMemberService printSingleMemberService = new PrintSingleMemberService();
		//printSingleMemberService.setMemberDAO(memberDAO); PrintSingleMemberService에서 memberDAO 필드에 @Autowired를 등록해놨을 경우 생략 o
		
		return printSingleMemberService;
	}
	
}
