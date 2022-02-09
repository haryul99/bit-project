package day3;

import java.util.LinkedList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		
		list.add("아아");
		list.add("아아1");
		list.add("아아2");
		
		list.set(0, "아아3"); //아아를 아아3으로 수정
		String s = list.get(0);
		int size = list.size();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
