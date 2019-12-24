package car;

public abstract class Car {
	
	void startEngine() {
		System.out.println("시동이 걸렸습니다.");
	}
	abstract void sound();
}
