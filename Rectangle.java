package test;

import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		System.out.println("가로와 높이를 입력하세요.");
		int w = a.nextInt();
		int h = a.nextInt();
		
		area ar = new area();
		
		System.out.println("면적은 :"+ar.area(w, h));
	}

}
