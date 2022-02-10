package day5;

public class Mem1 {
	private String name;
	private int age;
	
	public Mem1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getage() {
		return age;
	}
	public int equals(Mem1 o) {
		if(this.name.equals(o.getName())) {
			return 1;
		}return 0;
	}
	public int compareTo(Mem1 o) {
		return this.name.compareTo(o.getName());
	}
	
	public String toString() {
		return "이름 : "+name + ", 나이 : "+ age;
	}
	
	public int hashCode() {
		return name.hashCode() +age;
	}
}
