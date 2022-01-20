package com.workshop3.entity;

import java.util.Scanner;

public class Travel {
	private String travelCode;
	private String cityName;
	private String flight;
	private int travelType;
	private int maxPeople;
	private int reserved;
	public static final int INDIVIDUAL = 0;
	public static final int PACKAGE = 1;
	
	public Travel(String travelCode, String cityName, String flight, int travelType, int maxPeople) {
		this.travelCode = travelCode;
		this.cityName = cityName;
		this.flight = flight;
		this.travelType = travelType;
		this.maxPeople = maxPeople;
		reserved = 0;
	}
	public String getTravelCode() {
		return travelCode;
	}
	public String getCityName() {
		return cityName;
	}
	public String getFlight() {
		return flight;
	}
	public String getTravelType() {
		String result = null;
		if (travelType == INDIVIDUAL) {
			System.out.println("������������");
		}
		else if (travelType == PACKAGE) {
			System.out.println("��Ű�� ����");
		}
		return result; 
		}
	public int getMaxPeople() {
		return maxPeople;
	}
	public int getReserved() {
		return 3; //���ǰ�
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	public void printTravelInfo() {
		System.out.println("welcom~�ȳ��ϼ���~�Ϸ�������Դϴ�.");
		System.out.println("======< �޴� >======");
		System.out.printf("%1$6s  %2$4s  %3$5s  %3$s    %5$2d��     %5$2d��\n", travelCode, cityName, flight, getTravelType(), maxPeople, reserved);
		Scanner input  = new Scanner(System.in);
		System.out.print("���Ͻô� ���ڸ� �Է����ּ���");
			
	}
}
