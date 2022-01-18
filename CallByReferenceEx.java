
public class CallByReferenceEx {
	
	public void change(int[] a, int[] b) {
		int tmap = a[0];
		a[0] = b[0];
		b[0] = tmap;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {3}, y = {7};
		CallByReferenceEx ex = new CallByReferenceEx(); 
			System.out.println("x[0]="+x[0]+", y[0]="+y[0]);
			ex.change(x,y);
			System.out.println("x[0]="+x[0]+", y[0]="+y[0]);


	}

}
