package test;

import java.util.Scanner;

public class ArrayCreateByValueListExample1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("학생 수를 입력하세요.");
		int a = scan.nextInt();
		int[] scores = new int[a];
		
		getValue(scores);
		getAverage(scores);
		printArray(scores);		
	}
	
	public static void getValue(int[] array) {
		Scanner scan = new Scanner(System.in);	
		for(int i = 0; i< array.length; i++) {
			System.out.print("성적을 입력하시오. :");
			array[i] = scan.nextInt();
		}
		
	}
	public static void getAverage(int[] array) {
		int sum = 0;
		for(int i = 0 ;  i < 3 ; i++) {
		sum += array[i];
	}
	System.out.println("총합 :"+sum);
	
	
		double avg = (double) sum/3;
		System.out.println("평균 : "+avg);
	}
	
	public static void printArray(int[] array) {
		Scanner scan = new Scanner(System.in);	
		for(int i = 0 ; i < array.length ; i++) {
			System.out.println(array[i]);
		}
	}

}
