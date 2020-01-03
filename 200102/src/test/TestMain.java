package test;

import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		DBsql sql = new DBsql();
		Scanner scan = new Scanner(System.in);
		MentalTest mt = null;
		boolean run = true;
		while(true) {
			System.out.println("0.DB접속, 1.회원가입, 2.회원정보수정, 3.회원 탈퇴, 4.우울증 테스트, 5.");
			int selectNo = scan.nextInt();
			switch(selectNo) {
			case 0 :
				sql.dbConnection();
				break;
			case 99 :
				System.out.print("관리자아이디 : ");
				String id = scan.next();
				System.out.print("관리자비밀번호 : ");
				String password = scan.next();
				sql.adminDB(id, password);
				break;
			case 1 :
				mt = new MentalTest();
				System.out.print("아이디 : ");
				id = scan.next();
				mt.setId(id);
				System.out.print("비밀번호 : ");
				password = scan.next();
				mt.setPassword(password);
				System.out.print("이름 : ");
				String name = scan.next();
				mt.setName(name);
				System.out.print("핸드폰 번호 : ");
				String tel = scan.next();
				mt.setTel(tel);
				System.out.print("충전 금액 :");
				int balance = scan.nextInt();
				mt.setBalance(balance);
				sql.signUp(mt);
			case 2 :
				System.out.print("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.print("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				boolean check = sql.check(id, password);
				if(check) {
					mt = new MentalTest();
					mt.setId(id);
					System.out.println("로그인 되었습니다.");
					System.out.println("수정할 비밀번호를 입력해 주세요 : ");
					password = scan.next();
					mt.setPassword(password);
					System.out.println("수정할 핸드폰 번호를 입력해 주세요 : ");
					tel = scan.next();
					mt.setTel(tel);
					System.out.println("수정할 충전 금액을 입력해 주세요 : ");
					balance = scan.nextInt();
					mt.setBalance(balance);
					sql.updateMember(mt);
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
				break;
			case 3 :
				System.out.println("아이디를 입력해 주세요 : ");
				id = scan.next();
				System.out.println("비밀번호를 입력해 주세요 : ");
				password = scan.next();
				check = sql.check(id, password);
				if(check) {
					sql.deleteMember(id);
				}else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
			}}}}

		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		DBsql sql = new DBsql();
//		MentalTest mt = null;
//		Scanner scan = new Scanner(System.in);
//		int selectNum=0;
//		boolean run = true;
//		while(run) {
//		System.out.println("");
//		System.out.println("┌────────────┬───────────────┬──────────────────┬─────────────────────┬─────────────────────┬─────────────────────┬────────────┬─────────┐");
//		System.out.println("│1. 회원가입   │2. 회원탈퇴        │3. 우울증 테스트      │4. 스트레스 테스트        │5. 알코올중독 테스트     │6. 인터넷중독 테스트     │7. 상담예약   │8. 종료    │");
//		System.out.println("└────────────┴───────────────┴──────────────────┴─────────────────────┴─────────────────────┴─────────────────────┴────────────┴─────────┘");
//		System.out.print("> ");
//		selectNum = scan.nextInt();
//		switch(selectNum) {
		
		
//		case 3:
//			System.out.print("아이디 : ");
//			String id = scan.next();
//			System.out.println("비밀번호 : ");
//			String password = scan.next();
//			
//			System.out.println("문제 1 : 나는 기운이 없고 우울하다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			System.out.println("문제 2 : 나는 쓸모가 없고 필요없는 사람이라고 느낀다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			System.out.println("문제 3 : 나는 눈물을 쏟거나 울고 싶어진다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			System.out.println("문제 4 : 나는 밤에 잠을 잘 못잔다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			System.out.println("문제 5 : 나는 별다른 이유 없이 피곤해진다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			System.out.println("문제 6 : 나는 안절부절 못해서 진정할 수가 없다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			System.out.println("문제 7 : 심장이 전보다 빨리 뛴다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			System.out.println("문제 8 : 나는 평소보다 신경이 더 날카롭다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			System.out.println("문제 9 : 내가 죽어야 남들이 더 잘 될 것이다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			System.out.println("문제 10 : 나는 미래를 희망적이지 않다고 생각한다.");
//			System.out.println("1. 그렇지 않다   2. 가끔 그렇다   3. 자주 그렇다   4. 항상 그렇다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//		
//			sql.DTest(String id, String password, int score, selectNum);
//		break;
//		
//		case 4:
//			System.out.print("아이디 : ");
//			String id = scan.next();
//			System.out.println("비밀번호 : ");
//			String password = scan.next();
//			
//			System.out.println("문제 1 : 눈이 피로하다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 2 : 어지럼증을 느낄 때가 있다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 3 : 귀에서 소리가 들릴 때가 있다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 4 : 때로는 입안에 염증이 생길 때가 있다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 5 : 좀처럼 피로가 없어지지 않는다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 6 : 쉽게 피로를 느낀다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 7 : 사소한 일로 화가 난다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 8 : 일할 의욕이 생기지 않는다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 9 : 잠을 쉽게 들지 못한다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 10 : 꿈을 많이 꾸거나 선잠을 잔다.");
//			System.out.println("1. 예   2. 아니오");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			sql.STest(String id, String password, int score, selectNum);
//		break;
//			
//		case 5:
//			
//			System.out.print("아이디 : ");
//			String id = scan.next();
//			System.out.println("비밀번호 : ");
//			String password = scan.next();
//			
//			System.out.println("문제 1 : 얼마나 술을 자주 마십니까?");
//			System.out.println("1. 전혀 안마심   2. 월 1~2회   3. 주 1~3회   4. 주4회 이상");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 2 : 술을 마시면 한번에 몇 잔정도 마십니까?");
//			System.out.println("1. 전혀 안마심   2. 소주 1~2잔   3. 소주 3~6잔   4. 소주 7잔 이상");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 3 : 한번에 소주 한 병 또는 맥주 4병 이상 마시는 경우는 얼마나 자주 있습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 4 : 지난 일년간 한번 술을 마시기 시작하면 멈출 수 없었던 때가 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 5 : 지난 일년간 평소 같으면 할수 있었던 일을 음주 때문에 하지 못한 적이 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 6 : 지난 일년간 술을 마신 다음날 해장술을 마신 적은 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 7 : 지난 일년간 음주 후에 죄책감을 느끼거나 후회한 적이 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 8 : 지난 일년간 음주 때문에 전날 밤에 있었던 일이 기억나지 않았던 적이 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 9 : 음주로 인해 자신이나 다른 사람을 다치게 한 적이 있습니까?");
//			System.out.println("1. 없음   2. 있었지만 지난 1년간은 없음   3. 지난 1년간 있었다.   4. 자주 있다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 10 : 친척이나 친구, 의사가 당신이 술 마시는 것을 걱정하거나 당신에게 술 끊기를 권유한 적이 있었습니까?");
//			System.out.println("1. 없음   2. 지난 반년동안 한번 있었다  3. 월 1회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			sql.AATest(String id, String password, int score, selectNum);
//			
//			
//			
//			
//		case 6:
//			
//			System.out.print("아이디 : ");
//			String id = scan.next();
//			System.out.println("비밀번호 : ");
//			String password = scan.next();
//			
//			System.out.println("문제 1 : 얼마나 술을 자주 마십니까?");
//			System.out.println("1. 전혀 안마심   2. 월 1~2회   3. 주 1~3회   4. 주4회 이상");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 2 : 술을 마시면 한번에 몇 잔정도 마십니까?");
//			System.out.println("1. 전혀 안마심   2. 소주 1~2잔   3. 소주 3~6잔   4. 소주 7잔 이상");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 3 : 한번에 소주 한 병 또는 맥주 4병 이상 마시는 경우는 얼마나 자주 있습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 4 : 지난 일년간 한번 술을 마시기 시작하면 멈출 수 없었던 때가 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 5 : 지난 일년간 평소 같으면 할수 있었던 일을 음주 때문에 하지 못한 적이 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 6 : 지난 일년간 술을 마신 다음날 해장술을 마신 적은 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 7 : 지난 일년간 음주 후에 죄책감을 느끼거나 후회한 적이 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 8 : 지난 일년간 음주 때문에 전날 밤에 있었던 일이 기억나지 않았던 적이 얼마나 자주 있었습니까?");
//			System.out.println("1. 없음   2. 월 1~2회   3. 주 1~2회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 9 : 음주로 인해 자신이나 다른 사람을 다치게 한 적이 있습니까?");
//			System.out.println("1. 없음   2. 있었지만 지난 1년간은 없음   3. 지난 1년간 있었다.   4. 자주 있다");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			System.out.println("문제 10 : 친척이나 친구, 의사가 당신이 술 마시는 것을 걱정하거나 당신에게 술 끊기를 권유한 적이 있었습니까?");
//			System.out.println("1. 없음   2. 지난 반년동안 한번 있었다  3. 월 1회   4. 거의 매일");
//			System.out.print("선택 > ");
//			selectNum = scan.nextInt();
//			
//			sql.IATest(String id, String password, int score, selectNum);
//		}
//			
//			
//		}
			
			
			
			
			
			
			
			
			
			
