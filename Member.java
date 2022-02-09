package day3;

import java.util.Iterator;
import java.util.Scanner;

public class Member {
	private String name;
	private int age;
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String GetName() {
		return name;
	}
	
	public int GetAge() {
		return age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name)&& (member.age ==age);
		}else {
			return false;
		}
	}	
	@Override
		public int hashCode() {
			
		   
		   
		   System.out.println();
		   
			return name.hashCode() + age;
		}
	
}
