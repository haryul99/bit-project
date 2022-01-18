
public class test {
	    public String sno ;//ÇÐ¹ø
	    public String name;
	    public int kor;
	    public int math;
	    public int eng;
	public int getTotal() {
		return kor + math + eng;
		
	}
	public void printAverage() {
		System.out.println(getTotal()/3);
	}
}
