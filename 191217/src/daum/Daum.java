package daum;

public class Daum {
//이름, 이메일, 비밀번호
	
	private String name;
	private String email;
	private String pw;
	
	public Daum(String name, String email, String pw) {
		this.name = name;
		this.email = email;
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
