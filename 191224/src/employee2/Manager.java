package employee2;

public class Manager extends Employee {
	int allowance;
	
	Manager(String name, int salary, int allowance){
		super(name, salary);
		this.allowance = allowance;
		
	}
	
	@Override
	double raiseSalary() {
		return getSalary()*1.2;
	}
	
}
