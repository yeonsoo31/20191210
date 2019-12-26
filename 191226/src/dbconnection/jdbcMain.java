package dbconnection;

import java.sql.Connection;

import java.util.*;

public class jdbcMain {

	public static void main(String[] args) {
		/*
		 * 1. DBConnection 클래스의 makeConnection 메소드 호출하여
		 * 	  DB 접속 정보(con)를 가져옴
		 * 2. con 객체를 가지고 DBsql 크래스의 메소드 호출하여 원하는
		 * 	  쿼리문 실행
		 */
		Connection con = null;
		con = DBConnection.makeConnection();
		// DB 접속은 한번만 하면 되니까 static으로 함.
		
		
		
		DBsql sql = new DBsql();
		/*
		 * 1번 선택하면 전체 조회, 2번 선택하면 데이터 저장
		 */
		Scanner scan = new Scanner(System.in);
		int selectNum=0;
		while(true) {
		System.out.println("1. 전체 조회, 2. 데이터 추가, 3. 데이터 추가(?사용), 4. 데이터 추가(입력)");
		selectNum = scan.nextInt();
		switch(selectNum) {
		case 1:
			sql.selectDB(con);
			break;
		case 2:
			sql.insertDB(con);
			break;
		case 3:
			sql.insertDB2(con);
			break;
		case 4:
			sql.insertDB3(con);
			break;
		}
//		sql.selectDB(con);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
