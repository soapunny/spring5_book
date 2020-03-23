package spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.config.AppContext;
import spring.dto.RegisterRequest;
import spring.entity.Member;
import spring.layer.memberLogic.ChangePasswordService;
import spring.layer.memberLogic.PrintEntireMemberService;
import spring.layer.memberLogic.PrintSingleMemberService;
import spring.layer.memberStorage.MemberDAO;
import spring.layer.memberLogic.MemberRegisterService;
import spring.util.DuplicateMemberException;
import spring.util.MemberNotFoundException;
import spring.util.MemberPrinter;
import spring.util.WrongIdPasswordException;

public class MainForSpring {
	//
	private static ApplicationContext applicationContext;
	
	public MainForSpring() {
		applicationContext = new AnnotationConfigApplicationContext(AppContext.class);
		
	}
	
	public void showMenu() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			selectMenu(bufferedReader);
		}
	}
	
	public void selectMenu(BufferedReader bufferedReader) throws IOException{
		System.out.print("#명령어를 입력하세요 : ");
		String command = bufferedReader.readLine().trim();

		if(command.equalsIgnoreCase("exit")) {
			System.out.println("Good bye !!");
			bufferedReader.close();
			System.exit(0);
		}else if(command.equals("list")){
			processListCommand();
			return;
		}else if(command.startsWith("find ")) {
			processFindCommand(command.split(" "));
			return;
		}else if(command.startsWith("new ")) {
			processNewCommand(command.split(" "));
			return;
		}else if(command.startsWith("change ")) {
			processChangeCommand(command.split(" "));
			return;
		}else {
			printHelp();
		}
	}
	
	public void processListCommand() {//Constructor DI 방식
		PrintEntireMemberService printEntireMemberService = applicationContext.getBean("printEntireMemberService", PrintEntireMemberService.class);
		MemberPrinter memberPrinter = applicationContext.getBean("memberPrinter", MemberPrinter.class);
		Collection<Member> list = printEntireMemberService.findAll();
		list.forEach(member -> memberPrinter.print(member));
	}
	
	public void processFindCommand(String[] args) {//Setter DI 방식
		if(args.length != 2) {
			printHelp();
			return;
		}
		
		PrintSingleMemberService printSingleMemberService = applicationContext.getBean("printSingleMemberService", PrintSingleMemberService.class);
		MemberPrinter memberPrinter = applicationContext.getBean("memberPrinter", MemberPrinter.class);
		try {
			Member foundMember = printSingleMemberService.findMember(args[1]);
			memberPrinter.print(foundMember);
		}catch (MemberNotFoundException e) {
			System.err.println("해당하는 맴버가 존재하지 않습니다.");
			return;
		}
	}
	
	public void processNewCommand(String[] args) {
		if(args.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService memberRegisterService = applicationContext.getBean("memberRegisterService", MemberRegisterService.class);
		RegisterRequest registerRequest = new RegisterRequest();
		
		registerRequest.setEmail(args[1]);
		registerRequest.setName(args[2]);
		registerRequest.setPassword(args[3]);
		registerRequest.setConfirmPassword(args[4]);
		
		if(!registerRequest.isPasswordEqualToConfirmPassword()) {
			System.err.println("암호와 암호확인이 일치하지 않습니다.");
			return;
		}
		
		try {
			memberRegisterService.register(registerRequest);
			System.out.println("새 계정을 등록했습니다!!");
		}catch (DuplicateMemberException e) {
			System.err.println("이미 존재하는 이메일 입니다.");
		}
	}
	
	public void processChangeCommand(String[] args) {
		if(args.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePasswordService = applicationContext.getBean("changePasswordService", ChangePasswordService.class);
		try {
			changePasswordService.changePassword(args[1], args[2], args[3]);
			System.out.println("비밀번호를 변경했습니다!!");
		}catch (MemberNotFoundException e) {
			System.err.println("존재하지 않는 이메일 입니다.");
		}catch (WrongIdPasswordException e) {
			System.err.println("비밀번호가 일치하지 않습니다.");
		}
	}
	
	public void printHelp() {
		System.out.println();
		System.out.println("================================");
		System.err.println(" 잘못된 명령 입니다.");
		System.out.println("==========명령어 사용법==============");
		System.out.println(" list");
		System.out.println(" find 이메일");
		System.out.println(" new 이메일 이름 암호 암호확인");
		System.out.println(" change 이메일 현재비밀번호 변경할비밀번호");
		System.out.println("================================");
	}

//================================main=====================================
	public static void main(String[] args) throws IOException{
		MainForSpring mainForSpring = new MainForSpring();
		mainForSpring.showMenu();
	}

}
