package day5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		String result;
		System.out.println("�Է��Ϸ��� ������ ���� ���Դϱ�? :");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0 ; i < num ; i++) {
			System.out.println("�̸��� ��ȭ��ȣ�� �Է¼���. (�� : ȫ�浿 010-0001-1010)");
			System.out.println(i+1 +". �̸�, ��ȭ��ȣ>>" );
			String name = scan.next();
			String number = scan.next();
			map.put(name, number);
			
		}
		System.out.println("ã������ ȸ���� �̸��� :");
		String find = scan.next();
		if(map.containsKey(find)) {
			System.out.println(find +"�� ��ȭ��ȣ�� :"+ map.get(find));
		}else {
			System.out.println("�Է��Ͻ� �����͸� ã�� �� �����ϴ�.");
			}
			
		}
	}

