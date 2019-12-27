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
//		Connection con = null;
//		con = DBConnection.makeConnection();
		// DB 접속은 한번만 하면 되니까 static으로 함.
		
		
		
		DBsql sql = new DBsql();
		/*
		 * 1번 선택하면 전체 조회, 2번 선택하면 데이터 저장
		 */
		Scanner scan = new Scanner(System.in);
		Student student = new Student();
		int selectNum=0;
		List<Student> stulist = new ArrayList<Student>();
		boolean run = true;
		while(run) {
		System.out.println("0. DB접속, 1. 전체 조회, 2. 데이터 추가, 3. 데이터 추가(?사용), 4. 데이터 추가(입력), 5. 데이터 입력(학생필드)");
		selectNum = scan.nextInt();
		
		switch(selectNum) {
		case 0:
			sql.dbConnection();
			break;
		
		case 1:
			sql.selectDB();
			break;
		case 2:
			sql.insertDB();
			break;
		case 3:
			sql.insertDB2();
			break;
		case 4:
			sql.insertDB3();
			break;
		case 5:
			sql.insertDB4(student);
		case 6:
//			stulist = new ArrayList<Student>();
			stulist = sql.selectDB2();
			break;
		case 7:
			sql.selectDB3();
			break;
		case 8:
			sql.selectDB4();
			
			break;
		case 9:
			sql.insertDB5();
			break;
			
		case 10:
			sql.deleteDB1();
			break;
		case 11:
			System.out.println("종료");
			run = false;
			break;
		}
//		sql.selectDB(con);
		}
		
		
		
		for(int i=0; i<stulist.size(); i++) {
			System.out.println(stulist.get(i));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
