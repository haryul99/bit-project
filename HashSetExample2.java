package day3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashSetExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Member> set = new HashSet<Member>();
		Scanner scan = new Scanner(System.in); 

		set.add(new Member("�̱浿", 20));
		set.add(new Member("ȫ�浿", 30));

		System.out.println("�� ��ü�� : " + set.size());
		System.out.println();


		boolean result = true;
		while(result) {
			System.out.println("---------------------");
			System.out.println("1. ȸ������, 2.ȸ��Ż��, 3.ȸ�����, 4. ����");
			System.out.println("---------------------");
			int num = scan.nextInt();
			switch(num) {
			case 1 :
				System.out.println("�����Ͻ� ȸ�� ���̵� �Է��ϼ���.");
				String id = scan.next();
				System.out.println("��밡���� ���̵� �Դϴ�. ��й�ȣ�� �Է��ϼ���.");
				int age = scan.nextInt();
				Member m = new Member(id, age);
				set.add(m);
				break;

				//			public boolean equals(Object obj) {
				//				if(obj instanceof Member) {
				//					Member member = (Member) obj;
				//					return member.name.equals(name)&& (member.age ==age);
				//				}else {
				//					return false;
				//				}
				//			}	
			case 2 : 	
				System.out.println("Ż���Ϸ��� ���̵� �Է����ּ���.");
				String delName = scan.next();
				System.out.println("Ż���Ϸ��� ���̵��� ��й�ȣ�� �Է����ּ���.");
				int delAge = scan.nextInt();
				Member n = new Member(delName, delAge);
				Iterator<Member> it3 = set.iterator();
				while(it3.hasNext()){
					Member tm = it3.next();
					if(n.equals(tm)) {
						it3.remove();
						System.out.println(delName+"ȸ���� ������");
						break;
					}else System.out.println("�������� ����"); 
				}
//					System.out.println("ã�� �̸��� �Է��ϼ���.");
//					String n = scan.next();
//					Iterator<Member> it2 = set.iterator();
//					while(it2.hasNext()) {
//						if (it2.next().GetName().equals(n)) {
//							System.out.println("ã�� �����Ͱ� �ֽ��ϴ�.");
//							System.out.println("�����Ϸ��� �̸��� �Է��ϼ���.");
//							String n1 = scan.next();
//							System.out.println(n1+" ȸ���� ������");
//							break;
//						}else {
//							System.out.println("ã�� �����Ͱ� �����ϴ�.");
//						}
//					}
					//		   Iterator iter = set.iterator();
					//
					//		      while (iter.hasNext()) {
					//		         System.out.print(iter.next() + " ");
					//
					//		      }
				case 3 :
					for (Member m1 : set) {
						System.out.println("���̵� : " + m1.GetName() + ", ��й�ȣ : " + m1.GetAge());
					}
					break;
				case 4 : 
					System.out.println("�ý����� �����մϴ�.");
					result = false;


				


			}
		}
}
}