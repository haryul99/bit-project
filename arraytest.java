
public class arraytest {
	public static void main(String[] args) {
		String[] strings;
		String[] strings2; //����
		String[] strings3; //����
//		int[]  nums;
//		int[]  nums2;
//		nums = new int[5];  //����, default �ʱⰪ���� �ʱ�ȭ��, 1���� �迭
//		nums2 = new int[]{100, 200, 300}; // ����, ����� �ʱ�ȭ, 1���� �迭
		strings = new String[5];  //����, default �ʱⰪ���� �ʱ�ȭ��, 1���� �迭
		strings2 = new String[] {new String("java"), new String("python"), new String("db, sql")}; // ����, ����� �ʱ�ȭ, 1���� �迭
		strings3 = new String[]{"Djange","jsp/servlet","spring framework"};
//		System.out.println(nums.length);
//		System.out.println(nums2.length);
//		for (int idx=0;idx < nums.length;idx++) {
//			System.out.println(nums[idx]+"");
//		}
//		for (int n : nums2) { //������ ���ٸ� ����, advanced for�� , foreach��
//			System.out.println(n);
		for (int idx=0;idx < strings.length;idx++) {
			System.out.println(strings[idx]+"");
		}
//		for (int a :strings3) { //������ ���ٸ� ����, advanced for�� , foreach��
//			System.out.println(a);
//		}
		

int[][] nums;
//int[] nums[];


//nums = new int[5][5];
//nums = new int[5][ ];//�� ���� ����, 1���� �迭�� size�� �������� �ʾƵ� ��
//nums = new int[ ][5 ]; //������ ����
nums = new int[ ][ ] {  {1},
                        {1, 2},
                        {1, 2, 3 },
                        {1, 2, 3, 4}
                              };
  numss = new int[ ][ ] {  {1},
					      {3, 3},
					      {3, 3, 3 },
					      {1, 2, 3, 4}
					            };
     System.out.println(nums.length);//2���� �迭�� ��size
     System.out.println(nums[0].length);//2���� �迭�� ù��° 1���� �迭����size []index��ȣ
     System.out.println(nums[1].length);//2���� �迭�� ù��° 1���� �迭����size
     
     for (int idx=0;idx < strings.length;idx++) {
			for(int j = 0; j<nums[idx].length;j++) {
				System.out.println(nums[idx][j]+" ");
			}
			System.out.println();
		}
     numss.arraycopy(nums.length, nums[2],numss[2], 3 );
	}

	
}
