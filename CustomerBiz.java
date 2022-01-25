package com.workshop.biz;

import java.util.ArrayList;
import java.util.List;

import com.workshop.entity.Customer;
import com.workshop.util.CustomerUtil;

public class CustomerBiz implements ICustomerBiz{
	private ArrayList<Customer> customers=new ArrayList<Customer>();
	
	public void initializeCustomer() {
		//List<Customer> lists=new ArrayList<Customer>();
		insertCustomer(new Customer("Lee",28,"010-5678-1234"));
		insertCustomer(new Customer("Park",31,"010-4567-9876"));
		insertCustomer(new Customer("Choi",25,"010-1111-2222"));
		insertCustomer(new Customer("Hong",27,"010-4679-8522"));
	}
	public void printAllCustomer() {
		System.out.println("----------------------������----------------------");
		for(int i=0;i<customers.size();i++) {
			System.out.print(i+1+".[�̸�]"+customers.get(i).getName()+"  [����]"+customers.get(i).getAge()+"  [��ȭ��ȣ]"+customers.get(i).getPhone());
			System.out.println();
		}
		System.out.println("--------------------------------------------------");
	}
	public void insertCustomer(){
		System.out.println("�̸�:");
		String n=CustomerUtil.getUserInput();
		System.out.println("����:");
		String a=CustomerUtil.getUserInput();
		System.out.println("��ȭ��ȣ:");
		String p=CustomerUtil.getUserInput();
		Customer c=new Customer(n,Integer.parseInt(a),p);
		insertCustomer(c);
		System.out.println("@�������� �߰��Ͽ����ϴ�");
	}
	public void insertCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void deleteCustomer() {
		System.out.println("������ ����ȣ�� �Է��ϼ���");
		int cn=Integer.parseInt(CustomerUtil.getUserInput());
		customers.remove(cn-1);
		System.out.println("@"+cn+"�� �� ������ �����Ͽ����ϴ�.");
	}
	}
