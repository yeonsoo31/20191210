package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import bank.Bank;
import bank.DBConnection;

public class DBsql {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Scanner scan = new Scanner(System.in);
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}
	
	
	
	public void DTest(String id, String password, int score, int selectNum) {
		String sql = "SELECT Dscore FROM MENTALTEST WHERE PASSWORD = ? ";
		Scanner scan = new Scanner(System.in);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(2)==password){
					String sql2 = "UPDATE MENTALTEST SET DTEST = ? WHERE PASSWORD = ?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(2, password);
					score = rs.getInt(6);
					score = score+selectNum;
					pstmt.setInt(1, score);
				} else {
					System.out.println("아이디 또는 비밀번호가 틀립니다.");
				}
			pstmt.executeUpdate();
			}
			System.out.println("총점 : "+Dscore+"점");
			System.out.println("결과 : "+result+"입니다");
			if(Dscore<=7) {
			System.out.println("[7점이하] 정상음주입니다.");
			} else if(Dscore<=11) {
				System.out.println("[7~11점] “ 위험음주 수준으로 주의를 요합니다.”"); 
				System.out.println("아직까지는 특별히 심각한 음주로 인한 문제가 발생하지는 않았지만,");
				System.out.println("향후 음주로 인한 문제가 발생할 가능성이 있습니다.");
				System.out.println("음주량을 줄이거나 음주횟수를 줄여 적정음주를 실행하도록 하는 것이 좋습니다.");");
			} else if(Dscore<=19) {
				System.out.println("");
			} else if(Dscore>=20) {
				System.out.println("");
			}
			
		}catch(SQLException e) {
				e.printStackTrace();
			}
}
	
	
	
	
	
	
	public void STest(String id, String password, int score, int selectNum) {
		String sql = "SELECT Sscore FROM MENTALTEST WHERE PASSWORD = ? ";
		Scanner scan = new Scanner(System.in);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(2)==password){
					String sql2 = "UPDATE MENTALTEST SET STEST = ? WHERE PASSWORD = ?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(2, password);
					score = rs.getInt(6);
					score = score+selectNum;
					pstmt.setInt(1, score);
				} else {
					System.out.println("아이디 또는 비밀번호가 틀립니다.");
				}
			pstmt.executeUpdate();
			}
			System.out.println("총점 : "+Sscore+"점");
			System.out.println("결과 : "+result+"입니다");
			if(Dscore<=7) {
			System.out.println("[7점이하] 정상음주입니다.");
			} else if(Dscore<=11) {
				System.out.println("[7~11점] “ 위험음주 수준으로 주의를 요합니다.”"); 
				System.out.println("아직까지는 특별히 심각한 음주로 인한 문제가 발생하지는 않았지만,");
				System.out.println("향후 음주로 인한 문제가 발생할 가능성이 있습니다.");
				System.out.println("음주량을 줄이거나 음주횟수를 줄여 적정음주를 실행하도록 하는 것이 좋습니다.");");
			} else if(Dscore<=19) {
				System.out.println("");
			} else if(Dscore>=20) {
				System.out.println("");
			}
			
		}catch(SQLException e) {
				e.printStackTrace();
			}
}
	
	
	
	
	public void AATest(String id, String password, int score, int selectNum) {
		String sql = "SELECT AAscore FROM MENTALTEST WHERE PASSWORD = ? ";
		Scanner scan = new Scanner(System.in);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(2)==password){
					String sql2 = "UPDATE MENTALTEST SET AATEST = ? WHERE PASSWORD = ?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(2, password);
					score = rs.getInt(6);
					score = score+selectNum;
					pstmt.setInt(1, score);
				} else {
					System.out.println("아이디 또는 비밀번호가 틀립니다.");
				}
			pstmt.executeUpdate();
			}
			System.out.println("총점 : "+AAscore+"점");
			System.out.println("결과 : "+result+"입니다");
			if(Dscore<=7) {
			System.out.println("[7점이하] 정상음주입니다.");
			} else if(Dscore<=11) {
				System.out.println("[7~11점] “ 위험음주 수준으로 주의를 요합니다.”"); 
				System.out.println("아직까지는 특별히 심각한 음주로 인한 문제가 발생하지는 않았지만,");
				System.out.println("향후 음주로 인한 문제가 발생할 가능성이 있습니다.");
				System.out.println("음주량을 줄이거나 음주횟수를 줄여 적정음주를 실행하도록 하는 것이 좋습니다.");");
			} else if(Dscore<=19) {
				System.out.println("");
			} else if(Dscore>=20) {
				System.out.println("");
			}
			
		}catch(SQLException e) {
				e.printStackTrace();
			}
}
	
	
	
	
	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
}
