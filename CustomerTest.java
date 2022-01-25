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
			System.out.println("메뉴입력:");
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
			System.out.println("없는메뉴를 선택했습니다!! 메뉴를다시선택하세요");
			break;
		}
		}
		while(menu!=9);
		System.out.println("----------------------");
		System.out.println("프로그램을 종료합니다. Bye~");
		System.out.println("----------------------");
		
	}
	public static void printMenu() {
		System.out.println("==<<고객 관리 프로그램>>==");
		System.out.println("1. 전체 고객 정보 조회");
		System.out.println("2. 고객 정보 추가");
		System.out.println("3. 고객 정보 삭제");
		System.out.println("9. 시스템 종료");
	}
}
