package project2;

import java.sql.*;
import java.util.Scanner;

import test.MentalTest;

public class DBsql {
	int balance = 0;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}

	public void signUp(PcManagement pm) {
		String sql = "INSERT INTO PCMEMBER VALUES(?,?,?,?,0)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pm.getId());
			pstmt.setString(2, pm.getPassword());
			pstmt.setString(3, pm.getName());
			pstmt.setString(4, pm.getPhone());
			pstmt.executeUpdate();
			System.out.println("회원가입 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}

	public boolean check(String id, String password) {
		boolean check = true;
		String sql = "SELECT * FROM PCMEMBER WHERE ID = ? AND PASSWORD = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = true;
			}else {
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public void updateMember(PcManagement pm){
		String sql = "UPDATE PCMEMBER SET PASSWORD = ?, PHONE = ? WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pm.getPassword());
			pstmt.setString(2, pm.getPhone());
			pstmt.setString(3, pm.getId());
			pstmt.executeUpdate();
			System.out.println("회원 정보 수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteMember(String id) {
		String sql = "DELETE FROM PCMEMBER WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("회원 탈퇴 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void adminDB(String id, String password) {
		String sql = "SELECT PASSWORD FROM PCMEMBER WHERE ID = 'admin'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				if(password.equals(rs.getString("PASSWORD"))){
				System.out.println("관리자 아이디 접속 성공");
				String sql2 = "SELECT * FROM PCMEMBER";
				pstmt = con.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println("");
					System.out.print("아이디 : "+rs.getString("ID")+", ");
					System.out.print("비밀번호 : "+rs.getString("PASSWORD")+", ");
					System.out.print("이름 : "+rs.getString("NAME")+", ");
					System.out.print("전화번호 : "+rs.getString("PHONE")+", ");
					System.out.print("잔액 : "+rs.getInt("BALANCE")+", ");
					System.out.println("");	
			}}} else {
				System.out.println("관리자가 아닙니다");
			}
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void chargeDB(String id, int balance) {
		
		String sql = "SELECT BALANCE FROM PCMEMBER WHERE ID = ? ";
		Scanner scan = new Scanner(System.in);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				this.balance = rs.getInt("balance");
				}
		String sql2 = "UPDATE PCMEMBER SET BALANCE = ? WHERE ID = ?";
		pstmt = con.prepareStatement(sql2);
		pstmt.setInt(1, this.balance+balance);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
}
	
	
}