package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean
	public Greeter greeter() {//@Bean ��� �� �ش� �޼��尡 ������ ��ü�� �������� �����ϴ� �� ��ü�� ���
		Greeter greeter = new Greeter();//@Bean ������̼��� ���� �޼���� ��ü�� �����ϰ� �ʱ�ȭ�ؾ� �Ѵ�.
		greeter.setFormat("%s, �ȳ��ϼ���!");
		return greeter;
	}
}
