package spring.config;

import org.springframework.context.annotation.Bean;

import spring.layer.memberLogic.ChangePasswordService;
import spring.layer.memberLogic.MemberRegisterService;
import spring.layer.memberLogic.PrintEntireMemberService;
import spring.layer.memberLogic.PrintSingleMemberService;

public class ApplicationConfiguration2 {
	//
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService();//memberDAO 의존 자동 주입 설정
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {//세터를 통한 의존 주입이 필요하지 않다. 해당 클래스에의 memberDAO 필드에 @Autowired로 의존 자동 주입을 설정했기 때문이다.
		return new ChangePasswordService();
	}
	
	@Bean
	public PrintEntireMemberService printEntireMemberService() {
		return new PrintEntireMemberService();
	}
	
	@Bean
	public PrintSingleMemberService printSingleMemberService() {
		return new PrintSingleMemberService();
	}
	
}
