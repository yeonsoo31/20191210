package test;

public class Calculator3Main {

	public static void main(String[] args) {
		Calculator3 cal = new Calculator3();
		// 필드값 호출
		System.out.println(cal.pi1);
		System.out.println(cal.pi);
		System.out.println(Calculator3.pi);
		
		// 메소드 호출
		System.out.println(cal.add(5, 5));
		System.out.println(cal.subtract(5, 5));
		System.out.println(Calculator3.subtract(5, 5));
		
		System.out.println(cal.EARTH_RADIUS);
		System.out.println(Calculator3.EARTH_RADIUS);
	}

}
