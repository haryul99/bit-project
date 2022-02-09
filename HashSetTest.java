package day3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		Scanner scan = new Scanner(System.in);
		for (int i= 0 ; i <=4; i++) {
		System.out.println("추가할 회원의 이름 : ");
		String sum = scan.next();
		set.add(sum);}
		System.out.println(set);
		
	    Iterator iter = set.iterator();

	      while (iter.hasNext()) {
	         System.out.print(iter.next() + " ");

	      }

	      System.out.println();
	      for (String s : set) {
	         System.out.print(s + " ");
	}

}}
