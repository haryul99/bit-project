package day5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		String result;
		System.out.println("입력하려는 데이터 수는 얼마입니까? :");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0 ; i < num ; i++) {
			System.out.println("이름과 전화번호를 입력세요. (예 : 홍길동 010-0001-1010)");
			System.out.println(i+1 +". 이름, 전화번호>>" );
			String name = scan.next();
			String number = scan.next();
			map.put(name, number);
			
		}
		System.out.println("찾으려는 회원의 이름은 :");
		String find = scan.next();
		if(map.containsKey(find)) {
			System.out.println(find +"의 전화번호는 :"+ map.get(find));
		}else {
			System.out.println("입력하신 데이터를 찾을 수 없습니다.");
			}
			
		}
	}

