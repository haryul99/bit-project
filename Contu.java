package day5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Contu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		String result;
		System.out.println("나라 이름과 인구를 3개 입력하세요. (예 : korea 5000");
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0 ; i < 3 ; i++) {
			System.out.println(i+1 +". 나라이름, 인구>>" );
			String cont = scan.next();
			int per = scan.nextInt();
			map.put(cont, per);
			
		}
		
		result = findMax(map);
		System.out.println("제일 인구가 많은 나라는"+ result +","+ map.get(result));
	}
	public static String findMax (Map<String, Integer> map) {
		int max = 0;
		String cont="";
		Set<String> names = map.keySet();
		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			String name = it.next();
			int n = map.get(name);
			if(max < n) {
				max = n;
				cont = name;
			}
			
		}
		return cont;
	}
}
