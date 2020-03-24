package spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.layer.memberStorage.MemberDAO;
import spring.util.MemberPrinter;
import spring.util.VersionPrinter;

@Configuration
public class ApplicationConfiguration1 {
	//
	@Bean
	public MemberDAO memberDAO() {//해당 메서드가 반환한 객체를 스프링 빈으로 설정
		return new MemberDAO();
	}
	
	@Bean
	@Qualifier("memberDAOClone")
	public MemberDAO memberDAO2() {
		return new MemberDAO();
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
