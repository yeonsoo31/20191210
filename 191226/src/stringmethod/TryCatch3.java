package stringmethod;

public class TryCatch3 {

	public static void main(String[] args) {
		try {
		String str1 = "100";
		String str2 = "a100";
		System.out.println(str1+str1);
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		System.out.println(num1+num1);
		} catch(Exception a) { // Exception이라고 써도 됨
			System.out.print("오류 : ");
			a.printStackTrace();
		}
		
		
	}

}
