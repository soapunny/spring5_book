package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	//
	public static void main(String[] args) {
		//getBean은 singleton 형태로 한 객체를 계속해서 사용한다.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter greeter1 = ctx.getBean("greeter", Greeter.class);
		Greeter greeter2 = ctx.getBean("greeter", Greeter.class);
		
		System.out.println("(greeter1 == greeter2) -> "+(greeter1 == greeter2));
		ctx.close();
	}
}
