package day2;

public class DriverExample {
	static void Driver(Vehicle p) {
		p.run();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		
		Driver(new Bus());
		Driver(new Vehicle());
		Driver(new Taxi());

	}

}
