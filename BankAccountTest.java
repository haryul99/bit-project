package test;

import java.util.Scanner;

public class BankAccountTest {

	public static void main(String[] args) {

		BankAccount bank = new BankAccount();
		
		
		boolean run = true;
		
		while(run) {
			System.out.println("_________________________");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("���� >");
			Scanner scan = new Scanner(System.in);
			int a = scan.nextInt();
			
			switch(a) { 
			case 1 : System.out.println("�Ա��Ͻ� �ݾ��� �������ּ���.");
					Scanner sca = new Scanner(System.in);
					int money = sca.nextInt();
					bank.deposit(money);
				break;
			case 2 :System.out.println("����Ͻ� �ݾ��� �������ּ���."); 
					Scanner sc = new Scanner(System.in);
					int miu = sc.nextInt();
					bank.withdraw(miu);
				break;
			case 3 : bank.print();
				break;
			case 4 : System.out.println("���α׷��� �����մϴ�.");
			 		run = false;
			 	break;
	}

}
	}
}
