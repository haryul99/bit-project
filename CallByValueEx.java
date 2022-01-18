
public class CallByValueEx {
	public void change(int a, int b) {
		int tmap = a;
		a = b;
		b = tmap;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =3, y =7;
		CallByValueEx ex = new CallByValueEx(); 
			System.out.println("x="+x+", y="+y);
			ex.change(x,y);
			System.out.println("x="+x+", y="+y);


}
}