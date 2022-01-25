package com.workshop.test;

import com.workshop.biz.CustomerBiz;
import com.workshop.biz.ICustomerBiz;
import com.workshop.util.CustomerUtil;

public class CustomerTest {
	public static void main(String[] args) {
		ICustomerBiz biz = new CustomerBiz();
		biz.initializeCustomer();
		int menu=0;
		do {
			printMenu();
			System.out.println("�޴��Է�:");
			menu=Integer.parseInt(CustomerUtil.getUserInput());
		switch(menu) {
		case 1: 
			biz.printAllCustomer();
			break;
		case 2:
			biz.insertCustomer();
			break;
		case 3:
			biz.deleteCustomer();
			break;
		default:
			System.out.println("���¸޴��� �����߽��ϴ�!! �޴����ٽü����ϼ���");
			break;
		}
		}
		while(menu!=9);
		System.out.println("----------------------");
		System.out.println("���α׷��� �����մϴ�. Bye~");
		System.out.println("----------------------");
		
	}
	public static void printMenu() {
		System.out.println("==<<�� ���� ���α׷�>>==");
		System.out.println("1. ��ü �� ���� ��ȸ");
		System.out.println("2. �� ���� �߰�");
		System.out.println("3. �� ���� ����");
		System.out.println("9. �ý��� ����");
	}
}
