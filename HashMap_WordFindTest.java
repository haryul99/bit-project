package day5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMap_WordFindTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("java","�ڹ�");
		map.put("school", "�б�");
		map.put("map", "����");
		
		System.out.println("�� Entry �� : "+ map.size());

		System.out.println("**********keySet**********");
		Set<String> keySet = map.keySet();
		Iterator<String> keyInterator = keySet.iterator();
		while(keyInterator.hasNext()) {
			String key = keyInterator.next();
			String value = map.get(key);
			System.out.println("�ܾ� : " + key + " �ǹ�  : " + value);
		}
		//for ���� ���� print
		System.out.println("***********for************");
		for(String key : map.keySet()) {
			System.out.println(String.format("�ܾ� : %s, �ǹ� : %s ",  key, map.get(key)));
		}
		
		
		System.out.println();
		
		System.out.println("********entrySet***********");
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();

		while(entryIterator.hasNext()) {
			Map.Entry<String, String> entry = entryIterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("�ܾ� : " + key + " �ǹ�  : " + value);
		}
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("ã�� ���� �ܾ�");
		String word = scan.next();
		if(map.containsKey(word)) {
			System.out.println(map.get(word));
		}else {
			System.out.println("�Է��� �ܾ ã�� �� �����ϴ�.");
		}
		
		
	}

}
