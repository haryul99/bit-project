package com.workshop.entity;

import com.sun.java_cup.internal.runtime.Scanner;

public class Travel {
	private String travelCode;
	private String cityName;
	private String flight;
	private int travelType;
	private int reserved = 0;
	private int maxPeople;
	public static final int INDIVIDAL = 0;
	public static final int PACKAGE = 1;
	
	public Travel(String travelCode, String cityName, String flight, int travelType,int maxPeople) {
		this.travelCode = travelCode;
		this.cityName = cityName;
		this.flight = flight;
		this.travelType = travelType;
		this.maxPeople = maxPeople;
	}
	public String getTravelCode() {
		string coDe = null;
		if (coDe == INDIVIDAL) {
			System.out.println("������������");
		}else {
			System.out.println("��Ű�� ����");
		}
		return coDe;
	}
	public String getCityName() {
		return cityName;
	}
	public String getFlight() {
		return flight;
	}
	public String getTravelType() {
		String re  = getTravelType();
		return re;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		
	}
	public void printTravellenfo() {
		System.out.println("Welcom~ �ȳ��ϼ���! �Ϸ� ������Դϴ�.");
		System.out.println("=======<<�޴�>>=======");
		System.out.println("1.��ü ���� ��ǰ ��ȸ");
		System.out.println("2. ���� �������� ��ǰ ��ȸ");
		System.out.println("3. ��Ű������ ��ǰ ��ȸ");
		System.out.println("4. ���� ��ǰ ����");
		System.out.println("9. ����");
		System.out.println("====================");
		Scanner = Scanner(System.in);
		int a = input("##�޴��Է�");
		
	}
	
}
