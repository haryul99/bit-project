package test;

import java.util.Scanner;

public class BankAccount {
	int accountNumber; //���¹�ȣ
	String name; //������
	int balance = 10000; //�ܾ�
	
	
	
	public void deposit(int v) {
		balance += v;
	}
	public void withdraw(int m) {
		if(m > balance) {
			System.out.println("�ܾ��̺����մϴ�.");
		}else {
			balance -= m;
		}
		
	}
	
	public void print() {
		System.out.println("������ �ܾ��� "+balance+"�Դϴ�.");
	}

}