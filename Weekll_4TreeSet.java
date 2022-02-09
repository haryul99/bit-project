package day3;

import java.util.Scanner;
import java.util.TreeSet;

public class Weekll_4TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		TreeSet<String> treeSet = new TreeSet<String>();
		String name;
		
		for(int i=0; i<5; i++) {
			System.out.println("추가할 회원의 이름은 :");
			name = scan.next();
			treeSet.add(new String(name));
		}
		System.out.println(treeSet);
	}

}
