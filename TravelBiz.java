package com.workshop3.biz;

import com.workshop3.entity.Travel;

public class TravelBiz {
	private Travel[] travels;
	
	public void TravelBiz() {
		travels = new Travel[] {
				new Travel("TRV001", "뮌헨", "독일항공", Travel.INDIVIDUAL,10),
				new Travel("TRV002", "프라하", "독일항공", Travel.INDIVIDUAL,10),
				new Travel("TRV003", "LA", "독일항공", Travel.PACKAGE,10),
				new Travel("TRV004", "후쿠오카", "대한항공", Travel.INDIVIDUAL,10),
				new Travel("TRV005", "상해", "남방항공", Travel.PACKAGE,12),
		};
	}
	public void printAllTravels() {
		for (Travel t : travels) {
        	t.printTravelInfo();
        }
	}

	public void printindividualTravels() {
		for (Travel t : travels) {
			if (t.getTravelType().equals("개별자유여행")) {
				t.printTravelInfo();
			}
        }
	}

	public void printPackageTravels() {
		for (Travel t : travels) {
			if (t.getTravelType().equals("패키지여행")) {
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
					System.out.println("예약이 완료되었습니다.");
					t = travel;
				}else {
					System.out.println("예약 가능 인원이 초과되었습니다.(예약 가능 인원: "+people+"명)");
				}				
			} //outer if end
		}//for end
		return t;
	}
	public void prinTravelListTitle() {
		
	}
}
