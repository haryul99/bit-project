package day5;

public class throwTest {
	public class  RangeBoundsException extends Exception {  
	     private double last_tall = 161;
	     public RangeBoundsException (String message){
	               super(message);
	      }
	     public double getLast_tall(){
	            return last_tall;
	    }
	}
	public void checkTall(double tall)throws RangeBoundsException {
		if(tall > 180 )
			throw new RangeBoundsException("유효범위보다 높습니다.");
		if(tall < 130)
			throw new RangeBoundsException("유호범위보다 낮습니다.");
	}
	public double averageTall(double[] tall){
		double sum = 0.0;
		double total = 0;
		 for (double t : tall) {
			 total += t;
		 }
		 return total/tall.length;
		}
	
	public static void main(String[] args) {
		double[] middle_talls = new double[] { 152, 155.5, 148.5, 192, 160.2, 168, 165, 115, 159, 157, 170, 173};
		throwTest test = new throwTest();
		for (int i = 0; i < middle_talls.length; i++) {
			try {
				test.checkTall(middle_talls[i]);
			}catch(RangeBoundsException e) {
				System.out.println(e.getMessage());
				middle_talls[i] = e.getLast_tall();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.printf("올해의 중학생 평균키 : %1$.2f", test.averageTall(middle_talls));
	}
}