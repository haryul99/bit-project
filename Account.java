

public class Account {
	private int balance;
	
	public Account(int balance) {
	}
	public int getBalance() {
	
		return 0;
	}
	
	public void setBalance(int balance) {
		
	}
	//�Ա�
	public boolean deposit(int amount) { //amount �ݾ�
		if (amount <=0) {
			return false;
		}else {
			ar = getBalance();
			to = amount + ar;
			setBalance(to);
			return true;
		}
	}
	//����
	public boolean withdraw(int amount) { 
		return  true;
	}
}
