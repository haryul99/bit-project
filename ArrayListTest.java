package day2;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("ȫ��");
		list.add("�̰�����");
		list.add("��");
		list.add("������");
		list.add("�Ͽ���");
		
		System.out.println("������ ��õ �ý����Դϴ�.");
		int index = (int) (Math.random()*list.size());
		System.out.println("��õ ������ : "+ list.get(index));
		
	}

}
