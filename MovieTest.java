package test;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		Movie mov = new Movie();
		
		Scanner a = new Scanner(System.in);
		System.out.println("년도와 영화제목을 입력하세요.");
		int year = a.nextInt();
		String title = a.next();
//		a.nextLine();
//		mov.title = a.nextLine();
		
		System.out.println(mov.print(year, title));
	}

}
