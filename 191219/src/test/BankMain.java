package test;

import java.util.*;

public class BankMain {

	public static void main(String[] args) {
		
		/*
		 * 은행 프로그램
		 * 1. 고객 등록을 할 수 있다. 
		 * 	1.1 생성자를 이용한 방법 
		 *  1.2 getter, setter 이용한 방법 
		 * 2. 예금 기능을 수행할 수 있다. 
		 * 3. 출금 기능을 수행할 수 있다. 
		 * 	3.1 잔액이 0원 미만이면 출금 불가능 메시지를 출력한다. 
		 * 4. 잔액 확인을 할 수 있다. 
		 * 5. 고객 정보
		 *  - 고객번호, 이름, 계좌번호, 잔액
		 * 6. 고객 정보는 ArrayList에 저장한다.  
		 */
		List<String> list =	new ArrayList<String>();
		Map<String, String> Client = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);
		int select = 0;
		int count = 0;
		int deposit = 0;
		int withdraw = 0;
		int balance = 0;
		String number = null;
		String input = null;
		boolean run = true;
		while(run) {
		System.out.println("┌────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│ 1. 고객 등록   ┃   2. 예금   ┃   3. 출금   ┃   4. 잔액확인   ┃   5.고객 정보   ┃   6. 종료             │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────┘");
		System.out.print("원하시는 번호를 선택해주세요 : ");
		select = scan.nextInt();
		
		switch(select) {
		case 1 : 
			
			
			++count;
			System.out.println("");
			System.out.println("고객번호 : "+count);
			System.out.print("이름 : ");
			input = scan.next();
			System.out.print("계좌번호 : ");
			number = scan.next();
			Client.put(number, input);			
			System.out.println("등록이 완료되었습니다.");
			
			break;
			
		case 2 :
			System.out.println("");
			System.out.print("입금 : ");
			deposit = scan.nextInt();
			balance += deposit;
			System.out.println("입금이 완료되었습니다.");
			System.out.println("총 잔액 : "+balance+"원");
			break;
			
		case 3 :
			System.out.println("");
			System.out.print("출금 : ");
			withdraw = scan.nextInt();
			balance -= withdraw;
			if(balance<0) {
				System.out.println("잔액이 부족하여 출금이 불가합니다.");
				balance = balance + withdraw;
			} else {
			System.out.println("출금이 완료되었습니다.");
			System.out.println("총 잔액 : "+balance+"원");
			}
			break;
			
		case 4 :
			System.out.println("");
			System.out.println("총 잔액은 "+balance+"원 입니다.");
			break;
			
		case 5 :
			Set<String> keyValues = Client.keySet();
			Iterator<String> iterator = keyValues.iterator();
			iterator.hasNext();
				String key = iterator.next();
				String value = Client.get(key);
				System.out.println(key + ": "+value);
			System.out.println("");
			System.out.println("고객번호 : "+count);
			System.out.println("이름 : "+value);
			System.out.println("계좌번호 : "+key);
			System.out.println("잔액 : "+balance);
			break;
			
		case 6 :
			System.out.println("");
			System.out.println("이용해주셔서 감사합니다.");
			run = false;
		

//		case 5 :
//			Set<String> keyValues = Client.keySet();
//			Iterator<String> iterator = keyValues.iterator();
//			while(iterator.hasNext()) {
//				String key = iterator.next();
//				String value = Client.get(key);
//				System.out.println(key + ": "+value);}
			
			
			
			
		
		}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
