package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	//
	public static void main(String[] args) {
		//
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter greeter = ctx.getBean("greeter", Greeter.class);//getBean�� �� �� greeter �޼��� ����Ǿ� Greeter Ÿ�� ��ȯ
		String msg = greeter.greet("������");//"������, �ȳ��ϼ���!" ��ȯ
		System.out.println(msg);
		ctx.close();
	}
}
