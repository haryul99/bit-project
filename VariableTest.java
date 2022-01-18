
public class VariableTest {
	public int num;
//	public final int PORT=5000; // final이 선언된 상수는 초기화를 해줘야함 또한 변경이 불가능함
	public static int snum; //클래스는 sactic이라고 함
	
	public static void main(String[]args) {
		VariableTest test = new VariableTest();//생성자메소드가 뉴 뒤에오는 것
		System.out.println(test.num);
//		System.out.println(test.PORT);
		System.out.println(test.snum);
		test.num = 50;
		System.out.println(snum);
		
	}

}
