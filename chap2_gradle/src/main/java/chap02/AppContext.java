package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean
	public Greeter greeter() {//@Bean 등록 시 해당 메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록
		Greeter greeter = new Greeter();//@Bean 어노테이션이 붙은 메서드는 객체를 생성하고 초기화해야 한다.
		greeter.setFormat("%s, 안녕하세요!");
		return greeter;
	}
}
