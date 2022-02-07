package test;

public class Employee {
	String name;
	String tel;
	long sal;
	
	public void print(String name, String tel, long sal) {
		this.name = name;
		this.tel = tel;
		this.sal = sal;
		
		System.out.println("이름 :"+name+ ",전화번호"+tel +", 연봉"+sal);
	}
}
