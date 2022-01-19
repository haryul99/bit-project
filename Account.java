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
			System.out.println("�ܾ� �����Դϴ� :" + balance + "��");
			System.exit(0);//Standalone application����
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
			System.out.println("�ݾ� �����Դϴ� :" + amount + "��");
		} else {
			this.balance += amount;
			System.out.println(amount+"���� �Ա��մϴ�. "  );
		}
	}

	public void substractBalance(int amount) {
		if (amount < 1) {
			System.out.println("�ݾ� �����Դϴ� :" + amount + "��");
		} else if(amount>balance){
			System.out.println("��ݺҰ�!! �ܰ� �����մϴ�. "  );
		}else {
			this.balance -= amount;
			System.out.println(amount+"���� ����մϴ�. "  );
		}		
	}

	public void printAccount() {
		System.out.println("====================== "  );
		System.out.println("����ȣ : " + custId  );
		System.out.println("���� : " + custName  );
		System.out.println("���¹�ȣ : " + accountNumber  );
		System.out.println("�ܾ� : " + balance  );
		System.out.println("====================== "  );
	}

}
