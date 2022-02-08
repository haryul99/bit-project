package test;

public class Rect {
	int width, height;
	
	public Rect(int w, int h) {
		this.width = w;
		this.height = h;
	}
	public double calcArea() {
		return (double)width*height;
	}
}
