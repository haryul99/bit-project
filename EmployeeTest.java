package test;

import java.util.Scanner;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner name = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���.");
		String n = name.next();
		
		Scanner tel = new Scanner(System.in);
		System.out.println("��ȭ��ȣ�� �Է��ϼ���.");
		String t = tel.next();
		
		Scanner sal = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���.");
		long s = name.nextInt();
		
		Employee em = new Employee();
		em.print(n,t,s);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("�޿��� �λ�����? : ");
//		int amt = sc.nextDouble();
//		em.upSalary(amt);
//		
		
	}

}
