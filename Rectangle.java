package test;

public class Rectangle {

	public static void main(String[] args) {
		 Rect[] list = new Rect[5];
		 for(int i = 0 ; i < list.length; i++) {
			 list[i] = new Rect(i,i);
		 }
		 for(int o = 0; o < list.length; o++) {
			 System.out.println(o+"번째 사각형의 면적 ="+list[o].calcArea());
		 }
}
}
