package test;

import java.util.Scanner;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner name = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String n = name.next();
		
		Scanner tel = new Scanner(System.in);
		System.out.println("전화번호를 입력하세요.");
		String t = tel.next();
		
		Scanner sal = new Scanner(System.in);
		System.out.println("연봉을 입력하세요.");
		long s = name.nextInt();
		
		Employee em = new Employee();
		em.print(n,t,s);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("급여의 인상율은? : ");
//		int amt = sc.nextDouble();
//		em.upSalary(amt);
//		
		
	}

}
