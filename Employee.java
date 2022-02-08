package test;

public class Employee {
	private String name;
	private String tel;
	private long sal;

	Employee(String name, String tel, long sal) {
		this.name = name;
		this.tel = tel;
		this.sal = sal;
	}

	public void print() {
		System.out.println("이름 :" + name + ",전화번호" + tel + ", 연봉" + sal);
	}

	public String getName() {
		return name;
	}
}
