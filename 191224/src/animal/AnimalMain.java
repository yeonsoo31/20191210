package animal;

public class AnimalMain {

	public static void main(String[] args) {

		//추상클래스는 객체화 불가능
//		Animal ani = new Animal();

		//자식클래스는 객체화 가능
		Dog dog = new Dog();
		dog.sound();
		dog.breath();
		
		Cat cat = new Cat();
		cat.sound();
		cat.breath();
		
		
		// 다형성(polymorphism)
		Animal ani = new Dog();
		ani.sound();
		ani = new Cat();
		ani.sound();
		
//		cat = new Dog(); 이렇게는 안됨
		
		
	}

}
