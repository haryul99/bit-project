

public class Account {
	private int balance;
	
	public Account(int balance) {
	}
	public int getBalance() {
	
		return 0;
	}
	
	public void setBalance(int balance) {
		
	}
	//입금
	public boolean deposit(int amount) { //amount 금액
		if (amount <=0) {
			return false;
		}else {
			ar = getBalance();
			to = amount + ar;
			setBalance(to);
			return true;
		}
	}
	//인출
	public boolean withdraw(int amount) { 
		return  true;
	}
}
