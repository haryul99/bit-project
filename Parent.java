package pkg1;

public class Parent {
	   // public String name ="parent";
		// protected String name ="parent";
//		String name ="parent"; //default access modifier
		private String name = "parent";
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}