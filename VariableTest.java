
public class VariableTest {
	public int num;
//	public final int PORT=5000; // final�� ����� ����� �ʱ�ȭ�� ������� ���� ������ �Ұ�����
	public static int snum; //Ŭ������ sactic�̶�� ��
	
	public static void main(String[]args) {
		VariableTest test = new VariableTest();//�����ڸ޼ҵ尡 �� �ڿ����� ��
		System.out.println(test.num);
//		System.out.println(test.PORT);
		System.out.println(test.snum);
		test.num = 50;
		System.out.println(snum);
		
	}

}
