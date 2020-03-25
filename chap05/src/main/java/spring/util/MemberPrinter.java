package spring.util;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.entity.Member;

@Component
public class MemberPrinter {
	//
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[회원정보] 아이디 : ");
		stringBuilder.append(member.getId());
		stringBuilder.append(", 이메일 : ");
		stringBuilder.append(member.getEmail());
		stringBuilder.append(", 이름 : ");
		stringBuilder.append(member.getName());
		stringBuilder.append(", 등록일 : ");
		
		String registedDateTime = member.getRegisterDateTime().toString();
		if(dateTimeFormatter != null)
			registedDateTime = dateTimeFormatter.format(member.getRegisterDateTime());
		stringBuilder.append(registedDateTime);
		
		System.out.println(stringBuilder);	
	}
	
	@Autowired(required = false) //DateTimeFormatter 빈 객체가 있을 경우만 실행, 빈 객체가 없더라도 DateTimeFormatter에 null을 전달하지 않는다.
	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
//	@Autowired	//DateTimeFormatter 빈 객체가 존재하지 않아도 실행, 빈 객체가 존재하지 않으면 dateTimeFormatter에 null값 주입
//	public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}
}
