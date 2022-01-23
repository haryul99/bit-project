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
			System.out.println("개별자유여행");
		}else {
			System.out.println("패키지 여행");
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
		System.out.println("Welcom~ 안녕하세요! 하률 여행사입니다.");
		System.out.println("=======<<메뉴>>=======");
		System.out.println("1.전체 여행 상품 조회");
		System.out.println("2. 개별 자유여행 상품 조회");
		System.out.println("3. 패키지여행 상품 조회");
		System.out.println("4. 여행 상품 예약");
		System.out.println("9. 종료");
		System.out.println("====================");
		Scanner = Scanner(System.in);
		int a = input("##메뉴입력");
		
	}
	
}
