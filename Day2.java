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
//		1���� 10���� ���
//		for (int i = 0; i < 10 ; i++) {
//			System.out.println(i+1);
//		}
		
	
////		Ȧ���� ���
//		for (int i = 0 ; i < 10 ; i++) {
//			System.out.println(i = i +1);
//		}
////		Ȧ���� ��� 1
//		for (int i = 1 ; i < 10 ; i++) {
//			if (i%2==1) {
//				System.out.println(i);
//			}
//		}
//		10���� �� ��	
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
////		 1~10������ Ȧ���� �������� ���
//		 for (int i = 11 ; i > 0 ; i-- ) {
//			 if(i%2 == 1)
//				 System.out.println(i);
//		 }
		
//		 5�� 5���� ���
//		 for (int i = 0; i < 5 ; i++) {
//			 for (int u = 1; u <= 5; u++) {
//				 System.out.print(u);
//			 }
//				 System.out.println();	 
//		 }
////		��ǥ�� ���
//		for (int i = 0; i < 5 ; i++) {
//			for(int o = 5; o > 0; o--) {
//				System.out.print("*");
//			}
//
//			System.out.println("");
//		}
////		���� �þ�� ��������
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
////		continue, break ����
//		for(int i = 0; i <3; i++) {
//			for(int j = 0; j<3;j++){
//				if(j==1) continue; //�ݺ�������� ���� ȸ���� �Ѿ��� ��
//				System.out.println("i="+i+",j="+j);
//			}		
//		}
//		a1 : //label
//		for(int i = 0; i <3; i++) {
//			a2 : //label
//			for(int j = 0; j<3;j++){
//				if(j==1) break a1; //���� ����� �ݺ��� Ż��
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
//          for(int i=2; i<=100; i++) // 1�� �Ҽ��� �ƴϹǷ� 2���� ����
//          { for(int j=2; j<=i; j++) { 
//               if(i%j ==0) {
//            	   count ++;}  
//          }   // �Ҽ��� 1�� �ڱ��ڽ����θ� �������Ƿ� �ڱ��ڽ����� �ѹ��� �������� �Ҽ�
//              if(count==1) {
//            	  System.out.print(i+" ");                  
//              }count=0;
//            }
//
//
////		�����ý�Ʈ��
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
//		System.out.println("�����ý�Ʈ �� �� ������" + countt +"�Դϴ�.");
//		
//		
//		up, down ����
		int chance = 5;
		Random random = new Random();
		int a = random.nextInt(100)+1;
		while (chance > 0) {
			System.out.print("���� �Է�:");
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
			System.out.printf("������ %d",a);
			}
		}
		
//		�ֹι�ȣ üũ
//		System.out.print("�ֹε�Ϲ�ȣ�� �Է����ּ���.-");
//		int number = input.nextInt();
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		// �Է¹��� �ֹι�ȣ
//		String str;
//
//		// check~!!
//		int[] chk = {2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};							   - 
//
//		// ���� ���� �� ������
//		int tot=0;
//		System.out.print("�ֹι�ȣ �Է�(xxxxxx-yyyyyy) : ");
//		str = br.readLine();
//		if (str.length() != 14)
//		{	System.out.println(">> �Է¿���~!!!");
//			return;
//		}
//		for (int i=0; i<13; i++)
//		{
//			if (i==6)
//				continue;
//			tot += chk[i] * Integer.parseInt(str.substring(i, (i+1)));
//		}
//		//-- ������� �����ϸ� �� �� �� �� ��� ���� ��Ȳ�̴�.
//		//   ��Ģ�� �°� ���� ������ ������ ����� ��� ���� ����
//		//   ���� tot �� ��� �ִ� ��Ȳ�� �ȴ�
//
//		int su = 11 - tot%11;
//		//-- �߰�����~!! (���� ��� ��� �� �߰� ���� �ʿ�)
//
//		//   su�� ���� ���� ����� �� �ڸ��� ���� ���
//
//		//   �ֹι�ȣ ������ �ڸ����� ���� �� ���� ��Ȳ
//
//		su = su % 10;
//		//-- ������� �����ϸ� �� �� �� �� ��� ���� ��Ȳ�̴�.
//
//		//   ���� ���� ����� ���� su �� ��� �ִ� ��Ȳ�� �ȴ�.
//
//
//
//		// ���� ��� ���
//
//		if (su==Integer.parseInt(str.substring(13)))
//
//			System.out.println(">> ��Ȯ�� �ֹι�ȣ~!!");
//
//		else
//			System.out.println(">> �߸��� �ֹι�ȣ~!!");

		Scanner input = new Scanner(System.in);
		System.out.print("�ֹι�ȣ �Է�(ex)XXXXXX-XXXXXXX==>");
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
////		������
//	int total = 0;
//	for(int i = 10; i<100;i++) {
//		int k = i;
//		int count4 = 0;
//		while(k>9) {
//			k=k/10*(k%10);
//			count4++;
//		}
//		if(count4>=4) {
//			System.out.println("����"+i+"�� ������"+count4+"�Դϴ�");
//			total++;
//		}
//	}
//	System.out.println("10~99������ ���� �� 4�̻��� �� ������ "+total+"�Դϴ�.");
		
//	System.out.println(Math.random());
//	//������ ���� 0<=| <1 
//	System.out.println((int)(Math.random()*100+1));
//	
	}
}

