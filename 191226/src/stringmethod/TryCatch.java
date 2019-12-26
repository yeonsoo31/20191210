package stringmethod;

import java.util.*;

public class TryCatch {

	public static void main(String[] args) {

		
		
		try {
			List<String> list = new ArrayList<String>();
			list.add("aa");
			for(int i=0; i<list.size();i++) {
				System.out.println(list.get(i));
			}
			
		} catch(IndexOutOfBoundsException e) {
			System.out.println("예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			System.out.println("무조건 나와요");
		}
		//try catch는 무조건 같이 써야하는데 finally는 써도되고 안써도 되는 선택.
		
		
	}

}
