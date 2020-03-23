package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.layer.memberLogic.ChangePasswordService;
import spring.layer.memberLogic.PrintEntireMemberService;
import spring.layer.memberLogic.PrintSingleMemberService;
import spring.layer.memberLogic.MemberRegisterService;
import spring.layer.memberStorage.MemberDAO;
import spring.util.MemberPrinter;

@Configuration
public class AppContext {
	//
	@Bean
	public MemberDAO memberDAO() {//해당 메서드가 반환한 객체를 스프링 빈으로 설정
		return new MemberDAO();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberDAO());
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {
		return new ChangePasswordService(memberDAO());
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public PrintEntireMemberService printEntireMemberService() {//Constructor DI method
		return new PrintEntireMemberService(memberDAO());
	}
	
	@Bean
	public PrintSingleMemberService printSingleMemberService() {//Setter DI method
		PrintSingleMemberService printSingleMemberService = new PrintSingleMemberService();
		printSingleMemberService.setMemberDAO(memberDAO());
		
		return printSingleMemberService;
	}
}
