package day2;

public class Min extends Calc{
	public Min(int a, int b) {
		setValuse(a, b);
	}
	public int calculate(int a, int b){
		int result = 0;
		result = a-b;
		return result;
	}
}
