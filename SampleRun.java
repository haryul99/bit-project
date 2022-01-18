import java.util.Scanner;

public class SampleRun {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("입금을 할 경우 1번을, 출금을 할 경우 2번을 눌러주세요.");
		int num = input.nextInt();
		
		int bon = 10000; 
		
		if (num == 1) {
			System.out.print("입금하실 금액을 기입해주세요.");
			int coin = input.nextInt();
			System.out.println(bon + coin);
		}
		if (num == 2) {
			System.out.print("출금하실 금액을 기입해주세요.");
			int mi = input.nextInt();
			if (mi > bon) {
				System.out.print("출금에 실패하셨습니다.");
			}
			if (mi <= bon) {
				System.out.print("남은 잔액"+(bon-mi)+"입니다.");
			}
		}
	}

}
