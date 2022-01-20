package com.workshop5.biz;

public class BookTest {

	public static void main(String[] args) {
		BookBiz biz = new BookBiz();
		int menu = 0;
		do {
		 printMenu();
		 System.out.print("## 메뉴 입력 :");
		 menu = Integer.parseInt(BookUtil.getUserInput());
		 switch(menu) {
		 case 1 :  
			 biz.printAllBooks();
			 System.out.println("-----------------------------------------------------");
			 break;
		 case 2 :  
			 biz.printAllMagazines();
			 System.out.println("-----------------------------------------------------");
			 break;			 
		 case 3 :  
			 biz.printAllNovels();
			 System.out.println("-----------------------------------------------------");
			 break;
		 case 4 :  
			 biz.printMagazineOneYearSubcription();
			 System.out.println("-----------------------------------------------------");
			 break;
		  
		 case 9 :
			 System.out.println("------------------------");
			 System.out.println("프로그램을 종료합니다. Bye~");
			 System.out.println("------------------------");
			 System.exit(0);
		default :
			System.out.println("메뉴를 잘못 입력하였습니다.");
		 }
		}while(menu!=9);

	}

	
	public static void printMenu() {
		System.out.println("===<< 도서 정보 프로그램 >> ===");
		System.out.println("1. 전체 도서 정보 조회");
		System.out.println("2. 전체 잡지 조회");
		System.out.println("3. 전체 소설 조회");
		System.out.println("4. 잡지 연간 구독료 조회");
		System.out.println("5. 소설 저자명 검색");
		System.out.println("6. 소설 가격 검색(최소값 ~ 최대값");
		System.out.println("9. 시스템 종료");
		System.out.println("===========================");
		
		
	}

}
