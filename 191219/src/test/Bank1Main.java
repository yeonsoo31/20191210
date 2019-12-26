package test;

import java.util.*;

public class Bank1Main {

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
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Bank1> member = new ArrayList<Bank1>();
		
		int select = 0;
		int count = 0;
		int balance = 0;
		int deposit = 0;
		int withdraw = 0;
		String name = null;
		String account = null;
		Bank1 bank1 = null;
		boolean run = true;
		while(run) {
		System.out.println("┌──────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│ 1. 고객 등록   ┃   2. 예금   ┃   3. 출금   ┃   4. 잔액확인   ┃   5.고객 정보   ┃   6. 종료         │");
		System.out.println("└──────────────────────────────────────────────────────────────────────────────────┘");
		System.out.print("원하시는 번호를 선택해주세요 : ");
		select = scan.nextInt();
		switch(select) {
		
		case 1 :
			++count;
			System.out.print("이름 : ");
			name = scan.next();
			System.out.print("계좌번호 : ");
			account = scan.next();
			System.out.print("잔액 : ");
			balance = scan.nextInt();
			bank1 = new Bank1(count,name,account,balance);
			System.out.print("등록완료");
			System.out.println(bank1);
			member.add(bank1);
			break;
			
		case 2 : 
			
			System.out.println("");
			System.out.print("입금액 > ");
			deposit = scan.nextInt();
			bank1.deposit(deposit);
			break;
			
		case 3 :
			System.out.println("");
			System.out.print("출금액 > ");
			withdraw = scan.nextInt();
			bank1.withdraw(withdraw);
			break;
			
		case 4 :
			System.out.print("잔액 : "+bank1.getBalance());
			System.out.println("");
			break;
			
		case 5 :
			for (int i = 0; i<member.size(); i++) {
			System.out.println(member.get(i));
			}
			break;
			
		case 6 :
			System.out.println("");
			System.out.println("이용해주셔서 감사합니다.");
			run = false;
		
		
		
		}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
