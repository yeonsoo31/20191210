package employee;

public class EmployeeMain {

	public static void main(String[] args) {
		
		
		
		Employee employee = new Employee("유연수", 500);
		
		System.out.println(employee);
		
		Manager manager = new Manager("김현", 500, true);
		manager.getSalary();
		System.out.println(manager);
		
		Executive executive = new Executive("이용", 500, false, true);
		executive.getSalary();
		System.out.println(executive);
	}

}
