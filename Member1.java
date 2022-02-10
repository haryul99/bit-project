package day5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Member1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***********************************");
		System.out.println("            회원 관리 프로그램            ");
		System.out.println("***********************************");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 탈퇴");
		System.out.println("3. 회원 출력");
		System.out.println("4. 종료");
		System.out.println("***********************************");
		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴선택 >");
		int num = scan.nextInt();
		boolean run = true;
		TreeSet<Mem1> treeSet = new TreeSet<Mem1>();
		while(run) {
			switch (num) {
			case 1 : System.out.println("가입할 회원의 이름을 입력해주세요.");
			String name = scan.next();
			System.out.println("가입할 회원의 나이를 입력해주세요.");
			int age = scan.nextInt();
			Mem1 member = new Mem1(name, age);
			
			if(treeSet.add(member)) {
				System.out.println("회원가입이 완료되었습니다.");
			}else {
				System.out.println("이미 가입된 회원입니다. 다시 한 번 확인해주세요.");
			}
			break;
			case 2 : System.out.println("탈퇴할 회원의 이름을 입력해주세요.");
					String delname = scan.next();
					System.out.println("탈퇴할 회원의 나이를 입력해주세요.");
					int delage = scan.nextInt();
					Mem1 member1 = new Mem1(delname, delage);
					if(Iterator<Mem1> iter = treeSet.iterator(); iter.hasNext();) {
						Mem1 one = iter.next();
						if(one.equals(member1) == 1) {
							treeSet.remove(member1);
							System.out.println("회원가입이 완료되었습니다.");
						}else {
							System.out.println("이미 가입된 회원입니다. 다시 한 번 확인해주세요.");			
					}
					}
			break;
			case 3 : System.out.println("회원을 출력합니다.");
			for(Iterator<Mem1> iter = treeSet.iterator(); iter.hasNext();) {
				Mem1 one = iter.next();
				member.toString();
				System.out.println(one);
				
			}
			//회원을 출력하는 메소드
			break;
			case 4 : System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			}
		}
	}

}
