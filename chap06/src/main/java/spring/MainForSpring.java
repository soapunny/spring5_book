package spring;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.component.Client;
import spring.component.Client2;
import spring.config.AppConfig;

public class MainForSpring {
	//
	
	public static void main(String[] args) throws IOException {
		//
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Client client = applicationContext.getBean(Client.class);
		client.send();
		
		Client2 client2 = applicationContext.getBean(Client2.class);
		client2.send();
		
		applicationContext.close();
	}
}
