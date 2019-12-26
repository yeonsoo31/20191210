package phone;

public class SmartPhoneMain {

	public static void main(String[] args) {

		SmartPhone sp = new SmartPhone(); 
		
		sp.keyPad();
		sp.call();
		sp.receiveCall();
		sp.receiveMessage();
		sp.sendMessage();
		sp.play();
		sp.stop();
		System.out.println(sp.calculator(99, 99));
	}

}
