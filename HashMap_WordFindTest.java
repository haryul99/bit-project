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
		
		map.put("java","자바");
		map.put("school", "학교");
		map.put("map", "지도");
		
		System.out.println("총 Entry 수 : "+ map.size());

		System.out.println("**********keySet**********");
		Set<String> keySet = map.keySet();
		Iterator<String> keyInterator = keySet.iterator();
		while(keyInterator.hasNext()) {
			String key = keyInterator.next();
			String value = map.get(key);
			System.out.println("단어 : " + key + " 의미  : " + value);
		}
		//for 문을 통한 print
		System.out.println("***********for************");
		for(String key : map.keySet()) {
			System.out.println(String.format("단어 : %s, 의미 : %s ",  key, map.get(key)));
		}
		
		
		System.out.println();
		
		System.out.println("********entrySet***********");
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();

		while(entryIterator.hasNext()) {
			Map.Entry<String, String> entry = entryIterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("단어 : " + key + " 의미  : " + value);
		}
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("찾고 싶은 단어");
		String word = scan.next();
		if(map.containsKey(word)) {
			System.out.println(map.get(word));
		}else {
			System.out.println("입력한 단어를 찾을 수 없습니다.");
		}
		
		
	}

}
