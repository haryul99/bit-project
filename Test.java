//over load
public class Test {
	public Test() {
		System.out.println("Test()called");
	}
	public Test(int a) {
		System.out.println("Test(int) called");
	}
	public Test(int a, int b) {
		
		System.out.println("Test(int, int) called");
	}
	
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test(1);
		Test t3 = new Test(1, 100);
		
	}
}
