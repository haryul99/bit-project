package test;

import java.util.Scanner;

public class BankAccountTest {

	public static void main(String[] args) {

		BankAccount bank = new BankAccount();
		
		
		boolean run = true;
		
		while(run) {
			System.out.println("_________________________");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("선택 >");
			Scanner scan = new Scanner(System.in);
			int a = scan.nextInt();
			
			switch(a) { 
			case 1 : System.out.println("입금하실 금액을 기재해주세요.");
					Scanner sca = new Scanner(System.in);
					int money = sca.nextInt();
					bank.deposit(money);
				break;
			case 2 :System.out.println("출금하실 금액을 기재해주세요."); 
					Scanner sc = new Scanner(System.in);
					int miu = sc.nextInt();
					bank.withdraw(miu);
				break;
			case 3 : bank.print();
				break;
			case 4 : System.out.println("프로그램을 종료합니다.");
			 		run = false;
			 	break;
	}

}
	}
}
