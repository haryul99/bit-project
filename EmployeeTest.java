package test;

import java.util.Scanner;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] em = new Employee[3]; 
		String n;
		String t;
		long s;
		double amt;
		
		for(int i =0 ; i < em.length ; i++) {
		
		Scanner name = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���.");
		n = name.next();
		
		Scanner tel = new Scanner(System.in);
		System.out.println("��ȭ��ȣ�� �Է��ϼ���.");
		t = tel.next();
		
		Scanner sal = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���.");
		s = sal.nextInt();
		
//		em[i] = new Employee(n, t, s);
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("�޿��� �λ�����? : ");
//		int amt = sc.nextDouble();
//		em.upSalary(amt);
		}
		for(Employee e : em) {
			e.print();
		}
//		
		
	}

}
