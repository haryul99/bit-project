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

		set.add(new Member("이길동", 20));
		set.add(new Member("홍길동", 30));

		System.out.println("총 객체수 : " + set.size());
		System.out.println();


		boolean result = true;
		while(result) {
			System.out.println("---------------------");
			System.out.println("1. 회원가입, 2.회원탈퇴, 3.회원출력, 4. 종료");
			System.out.println("---------------------");
			int num = scan.nextInt();
			switch(num) {
			case 1 :
				System.out.println("가입하실 회원 아이디를 입력하세요.");
				String id = scan.next();
				System.out.println("사용가능한 아이디 입니다. 비밀번호를 입력하세요.");
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
				System.out.println("탈퇴하려는 아이디를 입력해주세요.");
				String delName = scan.next();
				System.out.println("탈퇴하려는 아이디의 비밀번호를 입력해주세요.");
				int delAge = scan.nextInt();
				Member n = new Member(delName, delAge);
				Iterator<Member> it3 = set.iterator();
				while(it3.hasNext()){
					Member tm = it3.next();
					if(n.equals(tm)) {
						it3.remove();
						System.out.println(delName+"회원이 삭제됨");
						break;
					}else System.out.println("존재하지 않음"); 
				}
//					System.out.println("찾는 이름을 입력하세요.");
//					String n = scan.next();
//					Iterator<Member> it2 = set.iterator();
//					while(it2.hasNext()) {
//						if (it2.next().GetName().equals(n)) {
//							System.out.println("찾는 데이터가 있습니다.");
//							System.out.println("삭제하려는 이름을 입력하세요.");
//							String n1 = scan.next();
//							System.out.println(n1+" 회원이 삭제됨");
//							break;
//						}else {
//							System.out.println("찾는 데이터가 없습니다.");
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
						System.out.println("아이디 : " + m1.GetName() + ", 비밀번호 : " + m1.GetAge());
					}
					break;
				case 4 : 
					System.out.println("시스템을 종료합니다.");
					result = false;


				


			}
		}
}
}