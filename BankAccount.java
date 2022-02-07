package test;

import java.util.Scanner;

public class BankAccount {
	int accountNumber; //계좌번호
	String name; //예금주
	int balance = 10000; //잔액
	
	
	
	public void deposit(int v) {
		balance += v;
	}
	public void withdraw(int m) {
		if(m > balance) {
			System.out.println("잔액이부족합니다.");
		}else {
			balance -= m;
		}
		
	}
	
	public void print() {
		System.out.println("고객님의 잔액은 "+balance+"입니다.");
	}

}