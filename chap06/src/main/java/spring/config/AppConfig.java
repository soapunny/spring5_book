package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.component.Client;
import spring.component.Client2;

@Configuration
public class AppConfig {
	//
	
	@Bean
	@Scope("prototype") //프로토타입의 빈 범위 설정 시, getBean을 통해 객체를 무한대로 만들 수 있다. 기본 값인 @Scope("singleton") 범위는 단 한 개의 객체만 계속 반환한다.
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	
	@Bean(initMethod="connect", destroyMethod="close")
	public Client2 client2() {// 설정 파일에서 @Bean이 초기화 될 때 connect 실행, AnnotaionConfigApplicationContext.close() 될 때 close 실행
		Client2 client2 = new Client2();
		client2.setHost("host");
		return client2;
	}
}
