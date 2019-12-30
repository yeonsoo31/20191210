package naver;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import naver.NaverMember;
import naver.DBsql;

public class JdbcMain {

	public static void main(String[] args) {
		DBsql sql = new DBsql();
		List<NaverMember> list = new ArrayList<NaverMember>();
		NaverMember nm = new NaverMember();
		Scanner scan = new Scanner(System.in);
		int selectNum=0;

		boolean run = true;
		while(run) {
		System.out.println("┌───────────┬────────────┬────────────┬───────────────");
		System.out.println("│0. DB접속    │1. 전체 조회  │2. 회원가입   │3. 회원정보수정   4. 회원탈퇴");
		System.out.println("└───────────┴────────────┴────────────┴────────────────");
		System.out.print("> ");
		selectNum = scan.nextInt();
		
		switch(selectNum) {
		case 0:
			sql.dbConnection();
			break;
		
		case 1:
			sql.selectDB();
			break;
		case 2:
			sql.insertDB(nm);
			break;
		case 3:
			System.out.println("┌───────────────┬───────────────┬───────────────┐");
			System.out.println("│1. 비밀번호 변경 │2. 이메일 변경    │3. 휴대전화 변경 │");
			System.out.println("└───────────────┴───────────────┴───────────────┘");
			System.out.print("> ");
			selectNum = scan.nextInt();
			if(selectNum==1) {	
				System.out.println("비밀번호 변경하실 아이디와 비밀번호를 입력해주세요.");
				System.out.print("아이디 : ");
				String id = scan.next();
				System.out.print("비밀번호 : ");
				String password = scan.next();
			sql.passwordupdateDB(id, password);
			break;
			} else if(selectNum==2) {
				System.out.println("이메일 변경하실 아이디와 비밀번호를 입력해주세요.");
				System.out.print("아이디 : ");
				String id = scan.next();
				System.out.print("비밀번호 : ");
				String password = scan.next();
				
			sql.emailupdateDB(id, password);
				break;
			} else if(selectNum==3) {
				System.out.println("전화번호 변경하실 아이디와 비밀번호를 입력해주세요.");
				System.out.print("아이디 : ");
				String id = scan.next();
				System.out.print("비밀번호 : ");
				String password = scan.next();
				
			sql.phoneupdateDB(id, password);
				break;
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
