package test;

import java.util.Scanner;

public class ArrayCreateByValueListExample1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("�л� ���� �Է��ϼ���.");
		int a = scan.nextInt();
		int[] scores = new int[a];
		
		getValue(scores);
		getAverage(scores);
		printArray(scores);		
	}
	
	public static void getValue(int[] array) {
		Scanner scan = new Scanner(System.in);	
		for(int i = 0; i< array.length; i++) {
			System.out.print("������ �Է��Ͻÿ�. :");
			array[i] = scan.nextInt();
		}
		
	}
	public static void getAverage(int[] array) {
		int sum = 0;
		for(int i = 0 ;  i < 3 ; i++) {
		sum += array[i];
	}
	System.out.println("���� :"+sum);
	
	
		double avg = (double) sum/3;
		System.out.println("��� : "+avg);
	}
	
	public static void printArray(int[] array) {
		Scanner scan = new Scanner(System.in);	
		for(int i = 0 ; i < array.length ; i++) {
			System.out.println(array[i]);
		}
	}

}
