package day5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Member1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***********************************");
		System.out.println("            ȸ�� ���� ���α׷�            ");
		System.out.println("***********************************");
		System.out.println("1. ȸ�� ����");
		System.out.println("2. ȸ�� Ż��");
		System.out.println("3. ȸ�� ���");
		System.out.println("4. ����");
		System.out.println("***********************************");
		Scanner scan = new Scanner(System.in);
		System.out.println("�޴����� >");
		int num = scan.nextInt();
		boolean run = true;
		TreeSet<Mem1> treeSet = new TreeSet<Mem1>();
		while(run) {
			switch (num) {
			case 1 : System.out.println("������ ȸ���� �̸��� �Է����ּ���.");
			String name = scan.next();
			System.out.println("������ ȸ���� ���̸� �Է����ּ���.");
			int age = scan.nextInt();
			Mem1 member = new Mem1(name, age);
			
			if(treeSet.add(member)) {
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
			}else {
				System.out.println("�̹� ���Ե� ȸ���Դϴ�. �ٽ� �� �� Ȯ�����ּ���.");
			}
			break;
			case 2 : System.out.println("Ż���� ȸ���� �̸��� �Է����ּ���.");
					String delname = scan.next();
					System.out.println("Ż���� ȸ���� ���̸� �Է����ּ���.");
					int delage = scan.nextInt();
					Mem1 member1 = new Mem1(delname, delage);
					if(Iterator<Mem1> iter = treeSet.iterator(); iter.hasNext();) {
						Mem1 one = iter.next();
						if(one.equals(member1) == 1) {
							treeSet.remove(member1);
							System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
						}else {
							System.out.println("�̹� ���Ե� ȸ���Դϴ�. �ٽ� �� �� Ȯ�����ּ���.");			
					}
					}
			break;
			case 3 : System.out.println("ȸ���� ����մϴ�.");
			for(Iterator<Mem1> iter = treeSet.iterator(); iter.hasNext();) {
				Mem1 one = iter.next();
				member.toString();
				System.out.println(one);
				
			}
			//ȸ���� ����ϴ� �޼ҵ�
			break;
			case 4 : System.out.println("���α׷��� �����մϴ�.");
				run = false;
				break;
			}
		}
	}

}
