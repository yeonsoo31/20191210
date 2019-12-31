package naver;

import java.sql.*;
import java.util.*;


public class DBsql {
	
	Connection con = null;
	// 쿼리문 전송을 위한 변수 선언
	PreparedStatement pstmt = null;
	// 조회(SELECT) 결과를 저장하기 위한 변수 선언
	ResultSet rs = null;
	NaverMember nm = null;
	Scanner scan = new Scanner(System.in);
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}
	// student 테이블 전체 조회 메소드
	public void selectDB() {
		// 실행하고자 하는 쿼리문을 String 변수로 지정
		String sql = "SELECT * FROM MEMBER";
		
		try {
			
			// 접속한 DB에 쿼리문을 전송할 준비
			pstmt = con.prepareStatement(sql);
			// 쿼리문을 실행하고 실행결과를 rs에 저장
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("");
				System.out.print("아이디 : "+rs.getString("id")+", ");
				System.out.print("비밀번호 : "+rs.getString("password")+", ");
				System.out.print("이름 : "+rs.getString("name")+", ");
				System.out.print("생년월일 : "+rs.getString("birth")+", ");
				System.out.print("성별 : "+rs.getString("gender")+", ");
				System.out.print("본인확인이메일 : "+rs.getString("email")+", ");
				System.out.print("휴대전화 : "+rs.getString("phone")+", ");
				System.out.println("");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
			
	
//	System.out.print("아이디 : ");
//	String id = scan.next();
//	
//	pstmt.setString(1, id);
//	
//	System.out.print("비밀번호 : ");
//	String password = scan.next();
//	pstmt.setString(2, password);
//	
//	System.out.print("이름 : ");
//	String name = scan.next();
//	pstmt.setString(3, name);
//	
//	System.out.print("생년월일 : ");
//	String birth = scan.next();
//	pstmt.setString(4, birth);
//	
//	System.out.print("성별 : ");
//	String gender = scan.next();
//	pstmt.setString(5, gender);
//	
//	System.out.print("본인 확인 이메일 : ");
//	String email = scan.next();
//	pstmt.setString(6, email);
//	
//	System.out.print("휴대전화 : ");
//	String phone = scan.next();
//	pstmt.setString(7, phone);
	
	public void insertDB(NaverMember nm) {
	nm = new NaverMember();

		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?)";
		try {
			
			pstmt = con.prepareStatement(sql);
			
				System.out.print("아이디 : ");
				String id = scan.next();
				nm.setId(id);
				pstmt.setString(1, nm.getId());
				
				System.out.print("비밀번호 : ");
				String password = scan.next();
				nm.setPassword(password);
				pstmt.setString(2, nm.getPassword());
				
				System.out.print("이름 : ");
				String name = scan.next();
				nm.setName(name);
				pstmt.setString(3, nm.getName());
				
				
				System.out.print("생년월일 : ");
				String birth = scan.next();
				nm.setBirth(birth);
				pstmt.setString(4, nm.getBirth());
				
				System.out.print("성별 : ");
				String gender = scan.next();
				nm.setGender(gender);
				pstmt.setString(5, nm.getGender());
				
				
				System.out.print("본인 확인 이메일 : ");
				String email = scan.next();
				nm.setEmail(email);
				pstmt.setString(6, nm.getEmail());
				
				
				System.out.print("휴대 전화 : ");
				String phone = scan.next();
				nm.setPhone(phone);
				pstmt.setString(7, nm.getPhone());
				
				pstmt.executeUpdate();
		


		
			} catch(SQLException e) {
			e.printStackTrace();
		}			
	}
	
	
	public void passwordupdateDB(String id, String password) {
		
		String sql = "SELECT PASSWORD FROM MEMBER WHERE ID = ?";
		
		Scanner scan = new Scanner(System.in);
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("password").equals(password)){
						String sql2 = "UPDATE MEMBER SET PASSWORD=? WHERE ID = ?";
						pstmt = con.prepareStatement(sql2);
					System.out.print("새로 변경할 비밀번호 : ");
					String newpassword = scan.next();
					pstmt.setString(1, newpassword);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
					System.out.println("수정완료");
				} else {
					System.out.println("입력하신 정보가 일치하지 않습니다");
				}
					} else { System.out.println("입력하신 정보가 일치하지 않습니다");
					}
		} catch(SQLException e) {
		e.printStackTrace();
	}			
	}
		
		
	
	public void emailupdateDB(String id, String password) {

		String sql = "SELECT PASSWORD FROM MEMBER WHERE ID = ?";
		Scanner scan = new Scanner(System.in);
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("password").equals(password)){
						String sql2 = "UPDATE MEMBER SET EMAIL=? WHERE ID = ?";
						pstmt = con.prepareStatement(sql2);
					System.out.print("새로 변경할 이메일 주소 : ");
					String newEmail = scan.next();
					pstmt.setString(1, newEmail);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
					System.out.println("수정완료");
					} else {
						System.out.println("입력하신 정보가 일치하지 않습니다");
					}
							} else {
							System.out.println("입력하신 정보가 일치하지 않습니다");
							}
				} catch(SQLException e) {
					e.printStackTrace();
	}			
	}
	
	
	
	public void phoneupdateDB(String id, String password) {

		String sql = "SELECT PASSWORD FROM MEMBER WHERE ID = ?";
		Scanner scan = new Scanner(System.in);
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("password").equals(password)){
						String sql2 = "UPDATE MEMBER SET PHONE=? WHERE ID = ?";
						pstmt = con.prepareStatement(sql2);
					System.out.print("새로 변경할 전화번호 : ");
					String newPhone = scan.next();
					pstmt.setString(1, newPhone);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
					System.out.println("수정완료");
					} else {
						System.out.println("입력하신 정보가 일치하지 않습니다");
					}
							} else {
							System.out.println("입력하신 정보가 일치하지 않습니다");
							}
				} catch(SQLException e) {
					e.printStackTrace();
	}			
	}
	
	
	
	
	
	public void deleteDB(String id, String password) {
		
		String sql = "SELECT PASSWORD FROM MEMBER WHERE ID = ?";
			Scanner scan = new Scanner(System.in);
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("password").equals(password)){
						String sql2 = "DELETE FROM MEMBER WHERE ID = ?";
						pstmt = con.prepareStatement(sql2);
					System.out.println("정말 탈퇴하시겠습니까?");
					System.out.println("┌──────┬─────────┐");
					System.out.println("│1. 네  │2. 아니요 │");
					System.out.println("└──────┴─────────┘");
					int answer = scan.nextInt();
					if(answer==1) {
						pstmt.setString(1, id);
						pstmt.executeUpdate();
						System.out.println("탈퇴완료");
					} else {
						System.out.println("탈퇴처리를 취소했습니다.");
				}
					} else {
						System.out.println("입력하신 정보가 일치하지 않습니다.");
					}}else {
						System.out.println("입력하신 정보가 일치하지 않습니다.");
					}
					}catch(SQLException e) {
					e.printStackTrace();
				}
			
	}
			
			
	public void adminDB(String id, String password) {
		String sql = "SELECT * FROM MEMBER";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(id.equals("admin")&&password.equals("0000")) {
			while(rs.next()) {
				System.out.println("");
				System.out.print("아이디 : "+rs.getString("id")+", ");
				System.out.print("비밀번호 : "+rs.getString("password")+", ");
				System.out.print("이름 : "+rs.getString("name")+", ");
				System.out.print("생년월일 : "+rs.getString("birth")+", ");
				System.out.print("성별 : "+rs.getString("gender")+", ");
				System.out.print("본인확인이메일 : "+rs.getString("email")+", ");
				System.out.print("휴대전화 : "+rs.getString("phone")+", ");
				System.out.println("");	
			}} else {
				System.out.println("입력하신 정보가 일치하지 않습니다.");
			}
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
		
		
		
		
		
		
		
		
		
		
		
					
			
			
			
			
	
}