package day2;

import java.util.Scanner;

public class Main {
	static void Ca(Calc c) {
		c.calculate(0, 0);
	}
	public static void main(String[] args) {
		Scanner hi = new Scanner(System.in);
		System.out.println("두 수를 입력하세요.");
		int num1 = hi.nextInt();
		int num2 = hi.nextInt();
		
		System.out.println("연산자를 입력하세요.");
		String ca = hi.next();
		
		if(ca.equals("-")){
//			@Override
//			Ca(new Min(setValuse(num1, num2)));
			Min result = new Min(num1,num2);
			System.out.println("값 : "+result.calculate(num1, num2));
		}else if (ca.equals("+")){
			Add result = new Add(num1,num2);
			System.out.println("값 : "+result.calculate(num1, num2));
			
		}else if (ca.equals("*")){
			mul result = new mul(num1,num2);
			System.out.println("값 : "+result.calculate(num1, num2));
		}else if (ca.equals("/")){
			div result = new div(num1,num2);
			System.out.println("값 : "+result.calculate(num1, num2));
		}else {
			System.out.println("잘못된 연산자를 입력하였습니다.");
		}
		

	}

}
