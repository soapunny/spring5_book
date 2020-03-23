package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	//
	public static void main(String[] args) {
		//
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter greeter = ctx.getBean("greeter", Greeter.class);//getBean을 할 때 greeter 메서드 실행되어 Greeter 타입 반환
		String msg = greeter.greet("스프링");//"스프링, 안녕하세요!" 반환
		System.out.println(msg);
		ctx.close();
	}
}
