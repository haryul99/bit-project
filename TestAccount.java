package workshop.account;

import java.util.Scanner;

public class TestAccount {

	public static void main(String[] args) {
		Account a2 = new Account("CUST01", "소지섭", "1-22-333", 100000);
		a2.printAccount();//고객정보 출력
		int menu = 0;//입력 받은  메뉴 값 저장 
		int amount = 0;  //입력 받은  금액 저장 
		do {
			menu = getMenuItem(); //메뉴 입력 받음
			switch (menu) {
			case 1:
				amount = getAccount();//금액 입력받음
				a2.addBalance(amount);
				System.out.println("==============");
				System.out.println("현재 잔액 : " + a2.getBalance());
				System.out.println("==============");
				break;
			case 2:
				amount = getAccount();
				a2.substractBalance(amount);
				System.out.println("==============");
				System.out.println("현재 잔액 : " + a2.getBalance());
				System.out.println("==============");
				break;
			case 9:
				System.out.println("Bye~ ");
				System.exit(0);
			}
		} while (menu != 9);

	}

public static int getUserInput() {
		Scanner input = new Scanner(System.in);
		int menu = input.nextInt();
		return menu;
	}
	public static int getMenuItem() {
		System.out.println("[  Menu  ] ");
		System.out.println("1. 입금");
		System.out.println("2. 출금 ");
		System.out.println("9. 종료 ");
		System.out.print("=> Menu 선택 : ");
		return getUserInput();
	}
	public static int getAccount() {
		Scanner input = new Scanner(System.in);
		System.out.print("금액 : ");
		return getUserInput();
	}

}
