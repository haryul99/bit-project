package day2;

public class MethodOverridingEx {
	static void paint(Shape p) {
		//shape를 상속받은 객체들이 매게변수로 넘어올 수 있음
		p.draw(); //p가 가리키는 객체에 오버라이딩된 draw()를 호출
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Line line = new Line();
		paint(line); // Line 의 draw()를 실행 "line"출력
	
		paint(new Shape());//Shape의 draw실행
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}

}
