package employee;

public class Executive extends Manager {
	
	boolean bonus;
	
	Executive(String name, int salary, boolean allowance, boolean bonus){
		super(name, salary, allowance);
		this.bonus = bonus;
	}
	
	
		
	@Override
	public String toString() {
		return "Executive [이름 = "+name+", 급여 = "+salary+", 관리자 수당 = "+allowance+", 보너스  = "+bonus+"]";
	}



	@Override
	int getSalary() {
		if(bonus) {
			salary = salary+(salary*30/100); 
		}
		return salary;
	}
}
