package day3;

import java.util.LinkedList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		
		list.add("�ƾ�");
		list.add("�ƾ�1");
		list.add("�ƾ�2");
		
		list.set(0, "�ƾ�3"); //�ƾƸ� �ƾ�3���� ����
		String s = list.get(0);
		int size = list.size();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
