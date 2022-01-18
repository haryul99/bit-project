
public class array2 {
	public static void main(String[] args) {
	int[] src = new int[10];  
			int[] target = new int[10];
				 
			for(int idx=0;idx<src.length;idx++) {
			    src[idx] = idx+1;
		        target[idx] = 100;
			}
			for(int n : src) {
			     System.out.print(n+" ");
			}
			System.out.println();
			for(int n : target) {
			     System.out.print(n+" ");
			}
			System.out.println();
			System.arraycopy(src, 4, target, 2, 4);	
			for(int n : target) {
			     System.out.print(n+" ");
			}
}
}