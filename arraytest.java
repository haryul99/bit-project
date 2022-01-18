
public class arraytest {
	public static void main(String[] args) {
		String[] strings;
		String[] strings2; //선언
		String[] strings3; //선언
//		int[]  nums;
//		int[]  nums2;
//		nums = new int[5];  //생성, default 초기값으로 초기화됨, 1차원 배열
//		nums2 = new int[]{100, 200, 300}; // 생성, 명시적 초기화, 1차원 배열
		strings = new String[5];  //생성, default 초기값으로 초기화됨, 1차원 배열
		strings2 = new String[] {new String("java"), new String("python"), new String("db, sql")}; // 생성, 명시적 초기화, 1차원 배열
		strings3 = new String[]{"Djange","jsp/servlet","spring framework"};
//		System.out.println(nums.length);
//		System.out.println(nums2.length);
//		for (int idx=0;idx < nums.length;idx++) {
//			System.out.println(nums[idx]+"");
//		}
//		for (int n : nums2) { //순차적 접근만 가능, advanced for문 , foreach문
//			System.out.println(n);
		for (int idx=0;idx < strings.length;idx++) {
			System.out.println(strings[idx]+"");
		}
//		for (int a :strings3) { //순차적 접근만 가능, advanced for문 , foreach문
//			System.out.println(a);
//		}
		

int[][] nums;
//int[] nums[];


//nums = new int[5][5];
//nums = new int[5][ ];//행 길이 고정, 1차원 배열의 size는 동일하지 않아도 됨
//nums = new int[ ][5 ]; //컴파일 오류
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
     System.out.println(nums.length);//2차원 배열의 행size
     System.out.println(nums[0].length);//2차원 배열의 첫번째 1차원 배열의행size []index번호
     System.out.println(nums[1].length);//2차원 배열의 첫번째 1차원 배열의행size
     
     for (int idx=0;idx < strings.length;idx++) {
			for(int j = 0; j<nums[idx].length;j++) {
				System.out.println(nums[idx][j]+" ");
			}
			System.out.println();
		}
     numss.arraycopy(nums.length, nums[2],numss[2], 3 );
	}

	
}
