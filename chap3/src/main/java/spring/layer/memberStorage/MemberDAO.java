package spring.layer.memberStorage;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import spring.entity.Member;

public class MemberDAO {
	//
	private static long nextId = 0;
	
	private static MemberDAO instance;
	private Map<String, Member> memberMap;//email:Member의 형태로 저장
	
	public MemberDAO() {
		memberMap = new LinkedHashMap<>();
	}
	
	public static MemberDAO getInstance() {
		synchronized(MemberDAO.class) {
			if(instance == null) {
				instance = new MemberDAO();
			}
		}
		
		return instance;
	}
	
	public Member selectByEmail(String email) {
		return memberMap.get(email);
	}
	
	public Collection<Member> selectAll(){
		return memberMap.values();
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		memberMap.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		memberMap.put(member.getEmail(), member); //해당 key값을 가진 value update!!
	}
}
