package day3;

public class MemberService {
	public boolean login(String id, int Password){
		if(Password == 12345) {
			return true;
		}else {
			return false;
		}
	}
	public void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}
