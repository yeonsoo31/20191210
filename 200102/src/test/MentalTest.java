package test;

public class MentalTest {
	
	private String id;
	private String password;
	private String name;
	private String tel;
	private int balance;
	private int dScore;
	private int sScore;
	private int aaScore;
	private int iaScore;
	
	MentalTest(){
		
	}
	
	public MentalTest(String id, String password, String name, String tel, int balance, int dScore, int sScore,
			int aaScore, int iaScore) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.balance = balance;
		this.dScore = dScore;
		this.sScore = sScore;
		this.aaScore = aaScore;
		this.iaScore = iaScore;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getdScore() {
		return dScore;
	}
	public void setdScore(int dScore) {
		this.dScore = dScore;
	}
	public int getsScore() {
		return sScore;
	}
	public void setsScore(int sScore) {
		this.sScore = sScore;
	}
	public int getAaScore() {
		return aaScore;
	}
	public void setAaScore(int aaScore) {
		this.aaScore = aaScore;
	}
	public int getIaScore() {
		return iaScore;
	}
	public void setIaScore(int iaScore) {
		this.iaScore = iaScore;
	}

	@Override
	public String toString() {
		return "MentalTest [id=" + id + ", password=" + password + ", name=" + name + ", tel=" + tel + ", balance="
				+ balance + ", dScore=" + dScore + ", sScore=" + sScore + ", aaScore=" + aaScore + ", iaScore="
				+ iaScore + "]";
	}
	
	
	
	
	

}