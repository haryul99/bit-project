package day2;

import java.util.Scanner;

public class Main {
	static void Ca(Calc c) {
		c.calculate(0, 0);
	}
	public static void main(String[] args) {
		Scanner hi = new Scanner(System.in);
		System.out.println("�� ���� �Է��ϼ���.");
		int num1 = hi.nextInt();
		int num2 = hi.nextInt();
		
		System.out.println("�����ڸ� �Է��ϼ���.");
		String ca = hi.next();
		
		if(ca.equals("-")){
//			@Override
//			Ca(new Min(setValuse(num1, num2)));
			Min result = new Min(num1,num2);
			System.out.println("�� : "+result.calculate(num1, num2));
		}else if (ca.equals("+")){
			Add result = new Add(num1,num2);
			System.out.println("�� : "+result.calculate(num1, num2));
			
		}else if (ca.equals("*")){
			mul result = new mul(num1,num2);
			System.out.println("�� : "+result.calculate(num1, num2));
		}else if (ca.equals("/")){
			div result = new div(num1,num2);
			System.out.println("�� : "+result.calculate(num1, num2));
		}else {
			System.out.println("�߸��� �����ڸ� �Է��Ͽ����ϴ�.");
		}
		

	}

}
