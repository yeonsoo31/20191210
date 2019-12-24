package employee;

public class Employee {
	
//	1. Employee 클래스 
//    A.	이름, 급여 정보를 가지고 있음. 
//    B.	급여 인상율 10% 
//	2. Manager 클래스 (Employee 상속)
//    A.	관리자 수당 있음. 
//    B.	급여 인상율 20%
//	3. Executive 클래스 (Manager 상속)
//    A.	보너스 있음. 
//    B.	급여 인상율은 30%
//	4. EmployeeMain 클래스 
//    A.	각 직급별 직원에 대한 객체를 만들어서 
//    B.	급여를 인상해주고 
//    C.	각 직원의 모든 정보 출력  
	
	String name;
	int salary;
	Employee(String name, int salary){
		this.name = name;
		this.salary = salary;
	}
	
	int getSalary() {
		return salary+(salary*10/100);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee  [이름 = " + name + ", 급여 = " + salary + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
	
	
	
	
	
	
}
