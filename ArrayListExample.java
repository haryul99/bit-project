package day3;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		list.add("Java0");
		list.add("Java1");
		list.add("Java");
		list.add(2,"Java2");
		list.add("Java3");
		
		int size = list.size();
		System.out.println("ÃÑ °´Ã¼¼ö : " + size);
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2 : "+ skill);
		System.out.println();
		
		for(int i = 0 ; i< list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" +str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("java3");
		
		for(int i = 0; i<list.size(); i ++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
	}

}
