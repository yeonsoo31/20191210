package stringmethod;

import java.util.*;

public class TryCatch2 {

	public static void main(String[] args) {
		/*
		 * 나눗셈 계산에서 분모가 0일 때 발생하는
		 * 예외(Exception)확인 후 이 예외에 대한
		 * 예외처리를 할 수 있는 코드를 작성해보세요.
		 */
//		Scanner scan = new Scanner(System.in);
//		
//		try {	
//		System.out.print("숫자입력 : ");
//			int x = scan.nextInt();
//			System.out.print(" ÷ ");
//			int y = scan.nextInt();
//			int result = x / y;
//			System.out.print(result);
//		} catch(ArithmeticException a) {
//			System.out.println("0으로 나눌 수 없습니다.");
//			System.out.print("오류코드 : ");
//			a.printStackTrace();
//			
//		}
		
		try {
			int num = 5/0;
			System.out.println(num);
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		
	}

}
