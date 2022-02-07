package test;

public class EnumMethodExample {
	public static void main(String[] args) {
//		name �޼ҵ� ���Ű�ü�� ������ �ִ� ���ڿ��� ����
		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println(name);
		
		//ordianl�޼ҵ� ��ü ���� �� �� ��° ���� ��ü���� �˷���/ ��ü ������ ��
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		
		//compareto �޼ҵ尳�������� �־��� ���� ��ü�� �������� ���ķ� �� ��° ��ġ�ϴ��� ��
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);
		
		//valueOf() �޼ҵ� �Ű������� �־����� ���ڿ��� ������ ���ڿ��� ������ ���� ��ü�� ����
		if(args.length == 1) {
			String strDay = args[0];
			Week weekDay = Week.valueOf(strDay);
			if(weekDay == Week.SATURDAY || weekDay == Week.SUNDAY) {
				System.out.println("�ָ��̱���");
			}else {
				System.out.println("�����̱���");
			}
		//values() �޼ҵ忭��Ÿ���� ��� ���� ��ü���� �迭�� ����� ����
			Week[] days = Week.values();
			for(Week day : days) {
				System.out.println(day);
			}
		}
		
	}
}