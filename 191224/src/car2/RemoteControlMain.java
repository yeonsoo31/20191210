package car2;

public class RemoteControlMain {

	public static void main(String[] args) {
		Television tv = new Television();
		tv.turnOn();
		tv.turnOff();
		tv.setVolume(100);
		tv.setMute(true);
		// Audio클래스를 RemoteControl의 구현클래스로 정의하여
		// 메소드 등을 정의하고
		// main 클래스에서 다형성을 적용하여
		// TV, Audio 객체를 만들어  메소드를 호출해보세요.
		
		RemoteControl rc = new Television();
		
		rc.turnOn();
		rc.setVolume(7);
		rc.setMute(true);
		rc.turnOff();
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(7);
		rc.setMute(true);
		rc.turnOff();
		
		RemoteControl.changeBattery();
		System.out.println(RemoteControl.MAX_VOLUME);
		
		
		SmartTelevision st = new SmartTelevision();
		
		st.turnOn();
		st.setVolume(7);
		st.setMute(true);
		st.turnOff();
		
		InternetSearch is = new SmartTelevision();
		is.search("이용 회장님");
		
		
	}

}
