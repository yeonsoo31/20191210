package test;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car();
		car.setGas(5);
		boolean gasState = car.isLeftGas();
		System.out.println(car.gas);
		if(gasState) {
			System.out.println("출발");
			car.run();
		}

	}

}
