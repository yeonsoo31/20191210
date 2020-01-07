package project2;

public class PcManagement {
	String id;
	String password;
	String name;
	String phone;
	int balance;
	
	PcManagement(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "PcManagement [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", balance=" + balance + "]";
	}
	
	
	
	

}