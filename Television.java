package day2;

public class Television implements RemoteControl {
	private int volume;
	
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	}
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
	}
	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
		this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("���� TV ���� : "+this.volume);
	}
	
}
