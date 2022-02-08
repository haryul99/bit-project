package day2;

abstract class Calc {
	private int a , b ;
	public void setValuse(int a, int b) {
		this.a =a;
		this.b =b;
	}
	public abstract int calculate(int a, int b);
}
