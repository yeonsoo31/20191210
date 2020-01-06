package project2;

import java.util.*;

import test.MentalTest;

public class PcManagementMain {

	public static void main(String[] args) {
		DBsql sql = new DBsql();
		Scanner scan = new Scanner(System.in);
		PcManagement pm = null;
		boolean run = true;
		while(run) {
			System.out.println("");
			System.out.println("┌────────────┬───────────────┬────────────┬────────────┬──────────────┬────────────┬─────────┬─────────────┐");
			System.out.println("│1. 회원가입   │2. 회원정보수정  │3. 회원 탈퇴  │4. 요금 충전  │5. PC사용시작   │6. 음식 주문  │7. 종료    │99. 관리자모드│");
			System.out.println("└────────────┴───────────────┴────────────┴────────────┴──────────────┴────────────┴─────────┴─────────────┘");
			System.out.print("> ");
			int selectNo = scan.nextInt();
			switch(selectNo) {
			case 0 :
				sql.dbConnection();
				break;
			case 1 :
				pm = new PcManagement();
				System.out.print("아이디 : ");
				String id = scan.next();
				pm.setId(id);
				System.out.print("비밀번호 : ");
				String password = scan.next();
				pm.setPassword(password);
				System.out.print("이름 : ");
				String name = scan.next();
				pm.setName(name);
				System.out.print("핸드폰 번호 : ");
				String phone = scan.next();
				pm.setPhone(phone);
				sql.signUp(pm);
				break;
			case 2 :
				System.out.print("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.print("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				boolean check = sql.check(id, password);
				if(check) {
					pm = new PcManagement();
					pm.setId(id);
					System.out.println("로그인 되었습니다.");
					System.out.print("수정할 비밀번호를 입력해 주세요 : ");
					password = scan.next();
					pm.setPassword(password);
					System.out.print("수정할 핸드폰 번호를 입력해 주세요 : ");
					phone = scan.next();
					pm.setPhone(phone);
					sql.updateMember(pm);
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
				break;
			case 3 :
				System.out.print("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.print("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				check = sql.check(id, password);
				if(check) {
					sql.deleteMember(id);
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
				break;
			case 4:
				System.out.print("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.print("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				check = sql.check(id, password);
				
				if(check) {
					pm = new PcManagement();
					pm.setId(id);
					System.out.println("로그인 되었습니다.");
					System.out.print("충전하실 금액을 입력해주세요 : ");
					int balance = scan.nextInt();
					sql.chargeDB(id, balance);
					System.out.println("충전 완료");
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.println("이용해주셔서 감사합니다.");
				run = false;
				break;
			case 99 :
				System.out.println("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.println("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				sql.adminDB(id, password);
				break;
			}
			}
		
	
	
	}
	
}