package day2;

public class MethodOverridingEx {
	static void paint(Shape p) {
		//shape�� ��ӹ��� ��ü���� �ŰԺ����� �Ѿ�� �� ����
		p.draw(); //p�� ����Ű�� ��ü�� �������̵��� draw()�� ȣ��
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Line line = new Line();
		paint(line); // Line �� draw()�� ���� "line"���
	
		paint(new Shape());//Shape�� draw����
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}

}
