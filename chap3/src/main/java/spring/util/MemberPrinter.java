package spring.util;

import spring.entity.Member;

public class MemberPrinter {
	//
	public void print(Member member) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[회원정보] 아이디 : ");
		stringBuilder.append(member.getId());
		stringBuilder.append(", 이메일 : ");
		stringBuilder.append(member.getEmail());
		stringBuilder.append(", 이름 : ");
		stringBuilder.append(member.getName());
		stringBuilder.append(", 등록일 : ");
		stringBuilder.append(member.getRegisterDateTime());
		
		System.out.println(stringBuilder);
	}
}
