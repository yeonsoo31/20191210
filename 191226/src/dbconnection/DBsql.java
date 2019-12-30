package dbconnection;

import java.sql.*;
import java.util.*;

// 쿼리문을 모아놓은 클래스
public class DBsql {
	// DB 접속을 위한 변수 선언
	Connection con = null;
	// 쿼리문 전송을 위한 변수 선언
	PreparedStatement pstmt = null;
	// 조회(SELECT) 결과를 저장하기 위한 변수 선언
	ResultSet rs = null;
	Student student = null;
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}
	
	
	// student 테이블 전체 조회 메소드
	public void selectDB() {
		// 실행하고자 하는 쿼리문을 String 변수로 지정
		String sql = "SELECT * FROM STUDENT";
		
		try {
			// 접속한 DB에 쿼리문을 전송할 준비
			pstmt = con.prepareStatement(sql);
			// 쿼리문을 실행하고 실행결과를 rs에 저장
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("studentno")+", ");
				System.out.print(rs.getString("name")+", ");
				System.out.print(rs.getInt("age")+", ");
				System.out.print(rs.getString("address")+", ");
				System.out.print(rs.getString("gender")+", ");
				System.out.println(rs.getString("phone"));
				
//				System.out.print(rs.getInt(1)+", ");
//				System.out.print(rs.getString(2)+", ");
//				System.out.print(rs.getInt(3)+", ");
//				System.out.print(rs.getString(4)+", ");
//				System.out.println(rs.getString(5));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
		// STUDENT 테이블에 데이터 추가
			public void insertDB() {
				String sql = "INSERT INTO STUDENT VALUES(6, '학생6', 11, '강원도 강릉시', '남성', '010-7777-7777')";
			try {
				pstmt = con.prepareStatement(sql);
				int result = pstmt.executeUpdate();
				// 결과가 성공하면 1 , 실패하면 0이 나오는데 그걸 보기위함
				System.out.println("insert 결과 : "+result);
				System.out.println("DB에 저장 성공!!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}
	
	
	public void insertDB2() {
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 10);
			pstmt.setString(2, "학생10");
			pstmt.setInt(3, 99);
			pstmt.setString(4, "경기도 성남시");
			pstmt.setString(5, "여성");
			pstmt.setString(6, "010-1234-5678");
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertDB3() {
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		Scanner scan = new Scanner(System.in);
		try {
			pstmt = con.prepareStatement(                                                              sql);
			
			System.out.print("학생번호 : ");
			int studentNo = scan.nextInt();
			pstmt.setInt(1, studentNo);
			
			System.out.print("이름 : ");
			String name = scan.next();
			pstmt.setString(2, name);
			
			System.out.print("나이 : ");
			int age = scan.nextInt();
			pstmt.setInt(3, age);
			
			System.out.print("주소 : ");
			String address = scan.next();
			pstmt.setString(4, address);
			
			System.out.print("성별 : ");
			String gender = scan.next();
			pstmt.setString(5, gender);
			
			System.out.print("전화번호 : ");
			String phone = scan.next();
			pstmt.setString(6, phone);
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}			
	}
	
	public void insertDB4(Student student) {
		
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		Scanner scan = new Scanner(System.in);
		try {
			pstmt = con.prepareStatement(sql);
			System.out.print("학생번호 : ");
			int x = scan.nextInt();
			student.setStudentno(x);
			pstmt.setInt(1, student.getStudentno());
			
			System.out.print("이름 : ");
			String x2 = scan.next();
			student.setName(x2);
			pstmt.setString(2, student.getName());
			
			
			System.out.print("나이 : ");
			int x3 = scan.nextInt();
			student.setAge(x3);
			pstmt.setInt(3, student.getAge());
			
			System.out.print("주소 : ");
			String x4 = scan.next();
			student.setAddress(x4);
			pstmt.setString(4, student.getAddress());
			
			System.out.print("성별 : ");
			String x5 = scan.next();
			student.setGender(x5);
			pstmt.setString(5, student.getGender());
			
			System.out.print("전화번호 : ");
			String x6 = scan.next();
			student.setPhone(x6);
			pstmt.setString(6, student.getPhone());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public List<Student> selectDB2() {
		List<Student> stulist = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT";
		Student stu = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stu = new Student();
				stu.setStudentno(rs.getInt("studentno"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setAddress(rs.getString("address"));
				stu.setGender(rs.getString("gender"));
				stu.setPhone(rs.getString("phone"));
				stulist.add(stu);
				/*
				 * ArrayList에 stu 객체를 저장하기
				 */
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stulist;
	}
	
	
	
	public void selectDB3() {
		
		String sql = "SELECT * FROM STUDENT WHERE GENDER = '여성'";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("studentno"));
				System.out.print(rs.getString("name"));
				System.out.print(rs.getInt("age"));
				System.out.print(rs.getString("address"));
				System.out.print(rs.getString("gender"));
				System.out.print(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
//	public void selectDB4() {
//		String sql = "SELECT * FROM STUDENT WHERE ADDRESS LIKE '인천%'";
//		try {
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				System.out.print(rs.getInt("studentno"));
//				System.out.print(rs.getString("name"));
//				System.out.print(rs.getInt("age"));
//				System.out.print(rs.getString("address"));
//				System.out.print(rs.getString("gender"));
//				System.out.println(rs.getString("phone"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void selectDB4() {
		Student stu = new Student();
		String sql = "SELECT * FROM STUDENT WHERE ADDRESS LIKE ? ";
		
		Scanner scan = new Scanner(System.in);
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.print("주소 : ");
			String address = scan.next();
			pstmt.setString(1, "%"+address+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("studentno"));
				System.out.print(rs.getString("name"));
				System.out.print(rs.getInt("age"));
				System.out.print(rs.getString("address"));
				System.out.print(rs.getString("gender"));
				System.out.println(rs.getString("phone"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	public void insertDB5() {
		Student stu = new Student();
		String sql = "UPDATE STUDENT SET PHONE=? WHERE STUDENTNO = ? ";
		Scanner scan = new Scanner(System.in);
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.print("수정할 학생 번호를 입력하세요 : ");
			int studentno = scan.nextInt();
			System.out.print("수정할 전화 번호를 입력하세요 : ");
			String phone = scan.next();
			pstmt.setString(1, phone);
			pstmt.setInt(2, studentno);


				pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	public void deleteDB1() {
		Student stu = new Student();
		String sql = "DELETE FROM STUDENT WHERE STUDENTNO = ?";
		Scanner scan = new Scanner(System.in);
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.print("삭제하실 학생 번호를 입력하세요 : ");
			int studentno = scan.nextInt();
			pstmt.setInt(1, studentno);


				pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
