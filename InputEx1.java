import java.util.Scanner;

public class InputEx1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("�⵵ ���� �Է�:");
		int year = input.nextInt();
		

	      if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
	          System.out.println(year + "���� ����");
	       } else {
	          System.out.println(year + "���� ���");
	       }
	    

		
//		���� �Է� �޾Ƽ� ����
//		if (num < 60) {
//			System.out.print("F");
//		}else if (num < 70) {
//			System.out.print("D");
//		}else if (num < 80) {
//			System.out.print("C");
//		}else if (num < 90) {
//			System.out.print("B");
//		}else {
//			System.out.print("A");
//		}
		
		
		//���
//		System.out.print("1~100������ ���� �Է� :");
//		int num1 = input.nextInt();
//		System.out.print("�����ڸ� �Է��ϼ��� :");
//		String op = input.next();
//		
//		if (op.equals("+") ) {
//			System.out.print(num +num1 );
//		}else if (op.equals("*")) {
//			System.out.print(num *num1);
//		}else if (op.equals("-")) {
//			System.out.print(num-num1);
//		}else if (op.equals("/")) {
//			System.out.print(num/num1);
//		}
		
		
		//¦�� /Ȧ�� check���
//		if (num % 2 == 0 ){
//			System.out.println("¦���Դϴ�.");
//		}else {
//			System.out.println("Ȧ���Դϴ�.");
//	}
	
		}
	}

