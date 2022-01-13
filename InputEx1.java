import java.util.Scanner;

public class InputEx1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("년도 정수 입력:");
		int year = input.nextInt();
		

	      if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
	          System.out.println(year + "년은 윤년");
	       } else {
	          System.out.println(year + "년은 평년");
	       }
	    

		
//		점수 입력 받아서 수행
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
		
		
		//계산
//		System.out.print("1~100사이의 정수 입력 :");
//		int num1 = input.nextInt();
//		System.out.print("연산자를 입력하세요 :");
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
		
		
		//짝수 /홀수 check출력
//		if (num % 2 == 0 ){
//			System.out.println("짝수입니다.");
//		}else {
//			System.out.println("홀수입니다.");
//	}
	
		}
	}

