package employee;

public class Manager extends Employee {
	
	boolean allowance;
	
	Manager(String name, int salary, boolean allowance){
		super(name, salary);
		this.allowance = allowance;
	}
	
	@Override
	public String toString() {
		return "Manager   [이름 = " + name + ", 급여 = " + salary + ", 관리자 수당 = " + allowance + "]" ;
	}

	@Override
	int getSalary() {
		if(allowance) {
			salary = salary+(salary*20/100);
			return salary;
		} else {
			return salary;
		}
		
	}
	
	
}
