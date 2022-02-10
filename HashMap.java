package day5;

public class HashMap {
	public String word;
	public String name;
	
	public HashMap(String word, String name) {
		this.word = word;
		this.name = name;
	}
	public boolean equals (Object obj) {
		if(obj instanceof HashMap) {
			HashMap hashMap =(HashMap) obj;
			return (word ==hashMap.word) && (name.equals(hashMap.name));
		}else {
			return false;
		}
	}
	public int hashcode() {
		return word.hashCode() + name.hashCode();
	}
}

