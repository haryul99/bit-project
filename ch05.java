package test;

import java.util.Scanner;

public class ch05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a = new Scanner(System.in);
		
		System.out.println("입력할 수를 기입해주세요.");
		int ssn = a.nextInt();
		String[] ad = new String[ssn];
		
		for(int i = 0; i< ad.length; i++) {
			System.out.print("수 입력하세요. :");
			ad[i] = a.next();
		}
		
		for (String s : ad) {
			System.out.println(s);
		}
	}

}
