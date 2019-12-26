package daum;

public class DaumMain {

	public static void main(String[] args) {
		//이름, 이메일, 비밀번호
		Daum daum = new Daum("유연수","yys@gmail.com","1234");
		System.out.println(daum.getName());
		daum.setName("이용");
		System.out.println(daum.getName());
		System.out.println(daum.getEmail());
		daum.setEmail("yys21321@gmail.com");
		System.out.println(daum.getEmail());
		System.out.println(daum.getPw());
		daum.setPw("123!%!@#");
		System.out.println(daum.getPw());
	}

}
