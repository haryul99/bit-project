package workshop.account;

public class Account {
	private String custId;
	private String custName;
	private String accountNumber;
	private int balance;
	
	public Account(String custId, String custName, String accountNumber, int balance) {
		this.custId = custId;
		this.custName = custName;
		this.accountNumber = accountNumber;
		if (balance < 1) {
			System.out.println("잔액 오류입니다 :" + balance + "원");
			System.exit(0);//Standalone application종료
		} else {
			this.balance = balance;
		}
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void addBalance(int amount) {
		if (amount < 1) {
			System.out.println("금액 오류입니다 :" + amount + "원");
		} else {
			this.balance += amount;
			System.out.println(amount+"원을 입금합니다. "  );
		}
	}

	public void substractBalance(int amount) {
		if (amount < 1) {
			System.out.println("금액 오류입니다 :" + amount + "원");
		} else if(amount>balance){
			System.out.println("출금불가!! 잔고가 부족합니다. "  );
		}else {
			this.balance -= amount;
			System.out.println(amount+"원을 출금합니다. "  );
		}		
	}

	public void printAccount() {
		System.out.println("====================== "  );
		System.out.println("고객번호 : " + custId  );
		System.out.println("고객명 : " + custName  );
		System.out.println("계좌번호 : " + accountNumber  );
		System.out.println("잔액 : " + balance  );
		System.out.println("====================== "  );
	}

}
