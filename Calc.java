import java.util.Scanner;

public class Calc {
	
	public int ccal(int n1, int n2, String op) {
		int result = 0;
		switch (op) {
		case "+" : result = (n1+n2) ; break;
		case "-" : result = (n1-n2); break;
		case "*" : result = (n1*n2); break;
		case "/" : result = (n1/n2); break;
		case "%" : result = (n1%n2); break;
		default : 
			result = -1;}
		return result;
//		Scanner input = new Scanner(System.in);
//		System.out.print("정수를 입력해보세요.");
//		int num = input.nextInt();
//		System.out.print("정수를 입력해보세요.");
//		int numm = input.nextInt();
//		System.out.print("연산자를 입력해보세요.");
//		char cal = input.next();
//		return num+numm;
	}
	public void jj(int n1, int n2) {
		System.out.println(Math.pow(n1, n2));
//		System.out.print("정수를 입력해보세요.");
//		int hy = input.nextInt();
//		System.out.print("정수를 입력해보세요.");
//		int hi = input.nextInt();
//		return hy**hi;
	}
}


