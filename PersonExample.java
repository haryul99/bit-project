package day2;

public class PersonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("123456789-12", "계백");
		
		System.out.println(p1.nation);
		System.out.println(p1.snn);
		System.out.println(p1.name);
		
//		p1.snn = "1231-123"; final은 변경 불가.
		p1.name = "을지문덕";

	}

}
