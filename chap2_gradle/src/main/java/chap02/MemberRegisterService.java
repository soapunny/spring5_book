package chap02;

import java.time.LocalDateTime;

class MemberDAO {
	//Driver �غ� �� connection �޼���
	//CRUD�� �����ϴ� �޼����
	
	public Member selectByEmail(String email) {
		Member member = null;
		//select�� ����
		return member;
	}
	
	public void insert(Member member) {
		//insert��
		
	}
}

class RegisterRequest {
	
	private Member member;
	//����� ��Ϲ޴´�.
	
	public String getEmail() {
		return member.getEmail();
	}
	public String getPassword() {
		return member.getPassword();
	}
	public String getName() {
		return member.getName();
	}
	public LocalDateTime getJoinDate() {
		return member.getJoinDate();
	}
}

class Member{
	//��� ���� Entity Class
	private long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime joinDate;
	
	public Member(String email, String password, String name, LocalDateTime joinDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.joinDate = joinDate;
	}
	
	public long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public LocalDateTime getJoinDate() {
		return joinDate;
	}
}

class DuplicatedMemberException extends RuntimeException {
	//
	private static final long serialVersionUID = 1L;
	public DuplicatedMemberException(String msg) {super(msg);}
}

//-----------------------------------------------------------------------------------
public class MemberRegisterService {
	//
	private MemberDAO memberDAO;
	
	public MemberRegisterService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public Long regist(RegisterRequest req) {
		Member member = memberDAO.selectByEmail(req.getEmail());
		
		if(member != null) {
			throw new DuplicatedMemberException("Duplicated email -> "+req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDAO.insert(newMember);
		return newMember.getId();
	}
}
