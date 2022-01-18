
public class MethodTest {
	private int num; //멤버변수
	public void setNum(int num) { //메소드가 호출될 때 로컬변수
		//값의 유효성 검사 코드
		//로컬변수와 멤버변수간의 이름이 충돌이 발생하며 메소드 내부에서는 로컬변수의 우선순위가 높으므로
		//멤버변수 앞에 클래스로부터 생성되는 참조변수를 사용해야함
		this.num = num;
	}
	
	public int getNum() {
		return num;
		
	
	}

}
