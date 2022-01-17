import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
//	
//		1부터 10까지 출력
//		for (int i = 0; i < 10 ; i++) {
//			System.out.println(i+1);
//		}
		
	
////		홀수만 출력
//		for (int i = 0 ; i < 10 ; i++) {
//			System.out.println(i = i +1);
//		}
////		홀수만 출력 1
//		for (int i = 1 ; i < 10 ; i++) {
//			if (i%2==1) {
//				System.out.println(i);
//			}
//		}
//		10까지 총 합	
//		int m = 0;
//		for (int i = 0 ; i < 11 ; i++) {
//			m=m+i;
//		}
//		System.out.println(m);
		
//		int sum = 0;
//		for(int i = 1; i <=num ;i++) {
//			if(num%i == 0) {
//				System.out.println(i);
//				sum=sum+i;
//			}
//		}
//		System.out.println(sum);
//		
//		 for (char i = 65 ; i <= 90 ; i++) {
//	         System.out.print(i+" ");
//	      }
//		
////		 1~10사이의 홀수만 역순으로 출력
//		 for (int i = 11 ; i > 0 ; i-- ) {
//			 if(i%2 == 1)
//				 System.out.println(i);
//		 }
		
//		 5행 5열로 출력
//		 for (int i = 0; i < 5 ; i++) {
//			 for (int u = 1; u <= 5; u++) {
//				 System.out.print(u);
//			 }
//				 System.out.println();	 
//		 }
////		별표로 출력
//		for (int i = 0; i < 5 ; i++) {
//			for(int o = 5; o > 0; o--) {
//				System.out.print("*");
//			}
//
//			System.out.println("");
//		}
////		점점 늘어나는 세모형식
//		for (int i = 0; i < 5 ; i++) {
//			for(int o = 5; o > 0; o--) {
//				System.out.print("*");
//			}
//
//			System.out.println("");
//		}
//		
//		for(int r = 0; r<5;r++) {
//			for(int c=0; c<r+1; c++) {
//				System.out.print("");
//			}
//			for(int c=0;c<5-r;c++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
////		continue, break 설명
//		for(int i = 0; i <3; i++) {
//			for(int j = 0; j<3;j++){
//				if(j==1) continue; //반복수행없이 다음 회차를 넘어가라는 식
//				System.out.println("i="+i+",j="+j);
//			}		
//		}
//		a1 : //label
//		for(int i = 0; i <3; i++) {
//			a2 : //label
//			for(int j = 0; j<3;j++){
//				if(j==1) break a1; //가장 가까운 반복문 탈출
//				System.out.println("i="+i+",j="+j);
//			}		
//		}
		
//		int z = 0;
//		int d = 1;
//		while (d < 10) {
//			z += (d+1);
//			d++;
////			z = z + d;
////			d++;
//		}
//		System.out.println(z);
//		
//		  int count=0;
//
//          for(int i=2; i<=100; i++) // 1은 소수가 아니므로 2부터 시작
//          { for(int j=2; j<=i; j++) { 
//               if(i%j ==0) {
//            	   count ++;}  
//          }   // 소수는 1과 자기자신으로만 나눠지므로 자기자신으로 한번만 나눠질때 소수
//              if(count==1) {
//            	  System.out.print(i+" ");                  
//              }count=0;
//            }
//
//
////		나르시스트수
//		int countt = 0;
//		for(int i=100;i<1000;i++) {
//			int h = i/100;
//			int p = (i%100)/10;
//			int o = i%10;
//			if(i == (h*h*h+p*p*p+o*o*o)) {
//				System.out.println("\t"+i);
//				countt++;
//			}
//		}
//		System.out.println("나르시스트 수 총 개수는" + countt +"입니다.");
//		
//		
//		up, down 게임
		int chance = 5;
		Random random = new Random();
		int a = random.nextInt(100)+1;
		while (chance > 0) {
			System.out.print("숫자 입력:");
			int num = input.nextInt();
		if(a < num) {
			System.out.println("Down");
			chance--;
		}else if(a > num) {
			System.out.println("Up");
			chance--;
		}else if (a == num) {
			System.out.print("you win.");
			chance = chance - 5;	
		}
		if(chance == 0) {
			System.out.printf("정답은 %d",a);
			}
		}
		
//		주민번호 체크
//		System.out.print("주민등록번호를 입력해주세요.-");
//		int number = input.nextInt();
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		// 입력받은 주민번호
//		String str;
//
//		// check~!!
//		int[] chk = {2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};							   - 
//
//		// 곱셈 연산 후 누적합
//		int tot=0;
//		System.out.print("주민번호 입력(xxxxxx-yyyyyy) : ");
//		str = br.readLine();
//		if (str.length() != 14)
//		{	System.out.println(">> 입력오류~!!!");
//			return;
//		}
//		for (int i=0; i<13; i++)
//		{
//			if (i==6)
//				continue;
//			tot += chk[i] * Integer.parseInt(str.substring(i, (i+1)));
//		}
//		//-- 여기까지 수행하면 ① 과 ② 를 모두 끝낸 상황이다.
//		//   규칙에 맞게 곱셈 연산을 수행한 결과를 모두 더한 값은
//		//   변수 tot 에 담겨 있는 상황이 된다
//
//		int su = 11 - tot%11;
//		//-- 추가연산~!! (최종 결과 출력 전 추가 연산 필요)
//
//		//   su에 대한 연산 결과가 두 자리로 나올 경우
//
//		//   주민번호 마지막 자릿수와 비교할 수 없는 상황
//
//		su = su % 10;
//		//-- 여기까지 수행하면 ③ 과 ④ 를 모두 끝낸 상황이다.
//
//		//   최종 연산 결과는 변수 su 에 담겨 있는 상황이 된다.
//
//
//
//		// 최종 결과 출력
//
//		if (su==Integer.parseInt(str.substring(13)))
//
//			System.out.println(">> 정확한 주민번호~!!");
//
//		else
//			System.out.println(">> 잘못된 주민번호~!!");

		Scanner input = new Scanner(System.in);
		System.out.print("주민번호 입력(ex)XXXXXX-XXXXXXX==>");
		String strJumin= input.read();
	         int digit = 2, sum = 0;
         for (int i=0;i<strJumin.length();i++){
              if(i==6) continue;
              if(digit == 10) digit=2;
              sum +=  (str.charAt(i)-48)*digit;
              digit++;
         }
          int result=(11-sum%11)%10;
          if(result ==(str.charAt(13)-'0'){
              System.out.println("\n CORRECT");
          }else{
 	  System.out.println("\n INCORRECT");
          }
		
		
		
//		
////		고집수
//	int total = 0;
//	for(int i = 10; i<100;i++) {
//		int k = i;
//		int count4 = 0;
//		while(k>9) {
//			k=k/10*(k%10);
//			count4++;
//		}
//		if(count4>=4) {
//			System.out.println("정수"+i+"는 고집수"+count4+"입니다");
//			total++;
//		}
//	}
//	System.out.println("10~99사이의 고집 수 4이상의 총 갯수는 "+total+"입니다.");
		
//	System.out.println(Math.random());
//	//난수의 범위 0<=| <1 
//	System.out.println((int)(Math.random()*100+1));
//	
	}
}

