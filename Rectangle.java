package test;

import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		System.out.println("���ο� ���̸� �Է��ϼ���.");
		int w = a.nextInt();
		int h = a.nextInt();
		
		area ar = new area();
		
		System.out.println("������ :"+ar.area(w, h));
	}

}
