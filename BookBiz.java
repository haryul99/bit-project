package com.workshop5.biz;

import com.workshop3.entity.Travel;

public class BookBiz {
	private Magazine[] magazines;
	private Novel[] novels;
	
	
	public void BookBiz() {
		magazines = new Magazines[] {
				new Magazine("The Confession","Grisham, John", 10500),
				new Magazine("Les Miserables", "Hugo, Victor", 17500),
				new Magazine("BreakThrough","lfill, Gwen", 47200),
				new Magazine("The Racketter","Grisham, John",38000),
		};
		
		novels = new Novel[] {
				new Novel("Cooking Light", "living,cooking", 15000, "America Cooking"),
				new Novel("AutoBild", "science, car", 16000, "Germany Car")
		};
	}
	public void printAllBooks() {
		System.out.println(magazines, novels);
	}
	public void printAllMagazines() {
		for (Magazine m : magazines) {
        	m.printTravelInfo();
        }
		System.out.println(magazines);
	}
	public void printAllNovels() {
		System.out.println(novels);
	}
	public void printMagazineOneYearSubcription() {
		
	}
	public void searchNovelByAuthor(String author) {
		this.author = author;
	}
	public void searchNovelByPrice(int minPrice, int maxPrice) {
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	private int calculateOneYearSubcriptionPrice(int price) {
		return 3;//ÀÓÀÇ°ª
	}
}
