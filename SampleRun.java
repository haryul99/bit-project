import java.util.Scanner;

public class SampleRun {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("�Ա��� �� ��� 1����, ����� �� ��� 2���� �����ּ���.");
		int num = input.nextInt();
		
		int bon = 10000; 
		
		if (num == 1) {
			System.out.print("�Ա��Ͻ� �ݾ��� �������ּ���.");
			int coin = input.nextInt();
			System.out.println(bon + coin);
		}
		if (num == 2) {
			System.out.print("����Ͻ� �ݾ��� �������ּ���.");
			int mi = input.nextInt();
			if (mi > bon) {
				System.out.print("��ݿ� �����ϼ̽��ϴ�.");
			}
			if (mi <= bon) {
				System.out.print("���� �ܾ�"+(bon-mi)+"�Դϴ�.");
			}
		}
	}

}
