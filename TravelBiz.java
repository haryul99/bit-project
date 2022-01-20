package com.workshop3.biz;

import com.workshop3.entity.Travel;

public class TravelBiz {
	private Travel[] travels;
	
	public void TravelBiz() {
		travels = new Travel[] {
				new Travel("TRV001", "����", "�����װ�", Travel.INDIVIDUAL,10),
				new Travel("TRV002", "������", "�����װ�", Travel.INDIVIDUAL,10),
				new Travel("TRV003", "LA", "�����װ�", Travel.PACKAGE,10),
				new Travel("TRV004", "�����ī", "�����װ�", Travel.INDIVIDUAL,10),
				new Travel("TRV005", "����", "�����װ�", Travel.PACKAGE,12),
		};
	}
	public void printAllTravels() {
		for (Travel t : travels) {
        	t.printTravelInfo();
        }
	}

	public void printindividualTravels() {
		for (Travel t : travels) {
			if (t.getTravelType().equals("������������")) {
				t.printTravelInfo();
			}
        }
	}

	public void printPackageTravels() {
		for (Travel t : travels) {
			if (t.getTravelType().equals("��Ű������")) {
				t.printTravelInfo();
			}
        }
	}
	public Travel reserveTravel(String travelCode, int reserveCount) {
		Travel t = null;
		for (Travel travel : travels) {
			if (travel.getTravelCode().equals(travelCode) ) {
				 int people = travel.getMaxPeople()-travel.getReserved();
				if (people> reserveCount){
					travel.setReserved(travel.getReserved()+reserveCount);
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					t = travel;
				}else {
					System.out.println("���� ���� �ο��� �ʰ��Ǿ����ϴ�.(���� ���� �ο�: "+people+"��)");
				}				
			} //outer if end
		}//for end
		return t;
	}
	public void prinTravelListTitle() {
		
	}
}
