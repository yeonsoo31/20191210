package car2;

public class CarMain {

	public static void main(String[] args) {
		Car car = null;
		car = new Sedan();
		car.load();
		car = new Truck();
		car.load();

	}

}
