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
//		System.out.print("������ �Է��غ�����.");
//		int num = input.nextInt();
//		System.out.print("������ �Է��غ�����.");
//		int numm = input.nextInt();
//		System.out.print("�����ڸ� �Է��غ�����.");
//		char cal = input.next();
//		return num+numm;
	}
	public void jj(int n1, int n2) {
		System.out.println(Math.pow(n1, n2));
//		System.out.print("������ �Է��غ�����.");
//		int hy = input.nextInt();
//		System.out.print("������ �Է��غ�����.");
//		int hi = input.nextInt();
//		return hy**hi;
	}
}


