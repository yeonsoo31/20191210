package project2;

import java.sql.*;
import java.util.*;

public class DBsql {
	int balance = 0 ; // 잔액 충전및 사용 을 하기위해 만든 필드
	Connection con = null; 
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private Map<Integer, List<String>> seats; // 좌석을 만들고 출력하기위한 필드
	                                          // 벨류값을 List로 준 이유 : 좌석의 가로번호 인덱스 번호로 인식하기위해
	private Scanner scan; // 스캐너 하기위해
	private List<String> seat; // 위에 seats List<String> 값을 넣어주기 위해..
	private int row; // 가로줄값 저장
	private int col; // 세로줄값 저장
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}
	
	public DBsql() {
		this.seats = new HashMap<Integer, List<String>>(); //메인에서 객체 선언을 할때 seats Map과 스캐너를 선언함
		this.scan = new Scanner(System.in);
	}
	
	public List<String> getSeat() {
		return seat;
	}

	public void setSeat(List<String> seat) {
		this.seat = seat;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}
	
	public Map<Integer, List<String>>getSeats(){
		return seats;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	public void signUp(PcManagement pm) { //회원가입
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

	public boolean check(String id, String password) {// 로그인
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
	
	public void updateMember(PcManagement pm){ //회원정보수정
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
	
	public void deleteMember(String id) { //회원탈퇴
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
	
	
	
	public void adminDB(String id, String password) { //관리자모드
		String sql = "SELECT PASSWORD FROM PCMEMBER WHERE ID = 'admin'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				if(password.equals(rs.getString("PASSWORD"))){
				System.out.println("관리자 아이디 접속 성공");
				boolean run = true;
				while(run) {
					System.out.println("┌─────────┬─────────┬──────────┐");
					System.out.println("│1.회원목록    │2.좌석현황    │3. 좌석정보  4. 종료   │");
					System.out.println("└─────────┴─────────┴──────────┘");
					System.out.print("입력 : ");
					int selectNum = scan.nextInt();
					switch(selectNum) {
					case 1: //전체조회
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
						}
					break;
					case 2: //좌석현황조회
						sql = "SELECT * FROM SEATS";
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							printSeats();
						}else {
							printSeats();
						}
						break;
					case 3: //좌석번호 지정  회원정보 확인
						String sql3 = "SELECT NAME FROM PCMEMBER P LEFT JOIN SEATS S ON (P.ID = S.ID) WHERE S.SEATS = ?";
						pstmt = con.prepareStatement(sql3);
						System.out.print("좌석번호를 입력해주세요 : ");
						String seats = scan.next();
						pstmt.setString(1, seats);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							System.out.println("사용자 이름 : "+rs.getString("NAME"));
						}else {
							System.out.println("사용중인 좌석이 아닙니다.");
						}
						break;
					case 4 :
						run = false;
						break;
					}
				}}else {
					System.out.println("관리자가 아닙니다");
				}} 
				
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void chargeDB(String id, int balance) { //요금충전
		
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

	public Map<Integer,List<String>> createSeats(){ //좌석 만들기 Map 을 사용하여 key값을 세로 인덱스번호
		                                            //Value값을 List로 주어서 가로 인덱스 번호 생성
		for(int i = 0; i < 4; i++) {
			this.seat = new ArrayList<String>(); //seat필드 ArrayList 선언
			for(int j = 0; j < 5; j++) {
				seat.add("☆");                  //List 에  j(인덱스번호)☆내용 을 j조건만큼 저장
			}
			seats.put(i, seat);               //Map seats 에 (key값(i),value값(seat) 을 저장해줌 
			                                  //이걸 i만큼 반복해서 map에 넣어줌
		}
		return seats;         //리턴값으로 seats 를 줌
	}
	
			
	public String inputScanner() { //스캐너사용
		scan = new Scanner(System.in);
		return scan.nextLine(); // nextLine = 스페이스바 눌러도 다음으로 안넘어감 엔터가 최종값
	}
	
	
	public void printSeats() { //좌석 출력
		for(int i = 0; i < 4; i++) { 
			this.seat = this.seats.get(i); // map seats를 get하는데 (i)=key값
			                               // 좌석 생성할때 for문돌려서 key값을 알수있음 
			for(String s : seat) {         // 한개씩 seat List에 저장해서
				System.out.print(s);       // seat 출력
			}
			System.out.println("");        // 한줄다음으로 *찍기 한것과 같음
		}
		
	}
	
	public boolean checkRow(int num) { //좌석 선택 할때 존재하는 좌석인지 알기위해 가로줄
		if(num < 0 || num > 6) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkCol(int num) { //좌석 선택할때 존재하는 좌석인지 알기위해 세로줄
		if(num < 0 || num > 5) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkSeats() { // 좌석 중복확인을 위해
		for(int i = 0; i < 4; i++) { 
			List<String> checkList = getSeats().get(this.row - 1); // 해당하는 가로줄 세로줄의 값이 ★이거이면 true 값을 보냄 
			for(String s: checkList) {                              
				if(checkList.get(this.col - 1).equals("★")) {     
					return true;                                  
				}
			}
		}
		return false;
	}
		
	public void pcUse(String id) {
		int balance1 = 0;
		System.out.println("사용할 금액을 선택해 주세요.");
		System.out.println("1.1000원 |2.3000원 |3.5000원 |4.10000원");
		int selectNo = scan.nextInt();
		switch(selectNo) {
		case 1 :
			int min = 1;
			String sql = "SELECT BALANCE FROM PCMEMBER WHERE ID = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getInt("BALANCE")>=1000) {
						balance1 = rs.getInt("BALANCE") - 1000;
						String sql1 = "UPDATE PCMEMBER SET BALANCE = ? WHERE ID = ?";
						pstmt = con.prepareStatement(sql1);
						pstmt.setInt(1, balance1);
						pstmt.setString(2, id);
						pstmt.executeUpdate();
						while(true) {
							System.out.println("pc사용할 좌석을 입력해 주세요 ex(x,y : x번째줄 y번째)");
							printSeats(); // 좌석출력
							
							String seatNum = inputScanner(); //좌석번호 입력

							String seatNumbers[] = seatNum.split(","); // seatNum 입력을 x,y식으로 했는데
							                                           // 이걸 , 기준으로 쪼개서 배열 각 각 넣음
							this.setRow(Integer.parseInt(seatNumbers[0]));//배열의 인덱스 0번값을 가져옴
							//Integer.parseInt = 입력받을때 String 으로 받아서 배열에 저장되었으니
							//                   문자열을 숫자형식으로 바꾸기 위해 사용
							this.setCol(Integer.parseInt(seatNumbers[1]));//배열의 인덱스 1번값을 가져옴
							
							if(checkRow(this.row)||checkCol(this.col)) { //존재 좌석 확인
								System.out.println("존재하지 않는 좌석 입니다.");
							}else {
								if(checkSeats()) { // 중복좌석 확인
									System.out.println("이미 사용중인 좌석입니다.");
									printSeats();
								}else {
									try {
										sql = "INSERT INTO SEATS (ID) VALUES (?)";
										pstmt = con.prepareStatement(sql);
										pstmt.setString(1, id);
										pstmt.executeUpdate();
										sql1 = "UPDATE SEATS SET SEATS = ? WHERE ID = ?";
										pstmt = con.prepareStatement(sql1);
										pstmt.setString(1, seatNum);
										pstmt.setString(2, id);
										pstmt.executeUpdate();
									} catch (SQLException e) {
										e.printStackTrace();
									}
									List<String> selectSeats = getSeats().get(this.row-1);
									selectSeats.set(this.col-1, "★");
									System.out.println(row+"번째 줄 "+col+"번째 좌석에 사용을 시작합니다.");
									// 가로 세로줄 좌석을 확인해서 ★를 넣어줌.
									printSeats();
									Runnable r = new Timer(id,seatNum,min); //러너블 선언
									Thread t = new Thread(r); // 스레드 선언
									t.start(); // 스레드 실행
									break;
								}
							}
						}
					}else {
						System.out.println("잔액이 부족합니다.");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case 2 :
			min = 3;
			sql = "SELECT BALANCE FROM PCMEMBER WHERE ID = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getInt("BALANCE")>=3000) {
						balance1 = rs.getInt("BALANCE") - 3000;
						String sql1 = "UPDATE PCMEMBER SET BALANCE = ? WHERE ID = ?";
						pstmt = con.prepareStatement(sql1);
						pstmt.setInt(1, balance1);
						pstmt.setString(2, id);
						pstmt.executeUpdate();
						while(true) {
							System.out.println("pc사용할 좌석을 입력해 주세요 ex(x,y : x번째줄 y번째)");
							printSeats();
							
							String seatNum = inputScanner();
							System.out.println("");
							
							seatNum = seatNum.trim();
							seatNum = seatNum.replace(" ", "");
							String seatNumbers[] = seatNum.split(",");
							
							this.setRow(Integer.parseInt(seatNumbers[0]));
							this.setCol(Integer.parseInt(seatNumbers[1]));
							String seats = this.row+","+this.col;
							
							if(checkRow(this.row)||checkCol(this.col)) {
								System.out.println("존재하지 않는 좌석 입니다.");
							}else {
								if(checkSeats()) {
									System.out.println("이미 사용중인 좌석입니다.");
									printSeats();
								}else {
									try {
										sql = "INSERT INTO SEATS (ID) VALUES (?)";
										pstmt = con.prepareStatement(sql);
										pstmt.setString(1, id);
										pstmt.executeUpdate();
										sql1 = "UPDATE SEATS SET SEATS = ? WHERE ID = ?";
										pstmt = con.prepareStatement(sql1);
										pstmt.setString(1, seatNum);
										pstmt.setString(2, id);
										pstmt.executeUpdate();
									} catch (SQLException e) {
										e.printStackTrace();
									}
									List<String> selectSeats = getSeats().get(this.row-1);
									selectSeats.set(this.col-1, "★");
									System.out.println(row+"번째 줄 "+col+"번째 좌석에 사용을 시작합니다.");
									printSeats();
									Runnable r = new Timer(id,seatNum,min);
									Thread t = new Thread(r);
									t.start();
									break;
								}
							}
							
						}
					}else {
						System.out.println("잔액이 부족합니다.");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case 3 :
			min = 5;
			sql = "SELECT BALANCE FROM PCMEMBER WHERE ID = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getInt("BALANCE")>=5000) {
						balance1 = rs.getInt("BALANCE") - 5000;
						String sql1 = "UPDATE PCMEMBER SET BALANCE = ? WHERE ID = ?";
						pstmt = con.prepareStatement(sql1);
						pstmt.setInt(1, balance1);
						pstmt.setString(2, id);
						pstmt.executeUpdate();
						while(true) {
							System.out.println("pc사용할 좌석을 입력해 주세요 ex(x,y : x번째줄 y번째)");
							printSeats();
							
							String seatNum = inputScanner();
							System.out.println("");
							
							seatNum = seatNum.trim();
							seatNum = seatNum.replace(" ", "");
							String seatNumbers[] = seatNum.split(",");
							
							this.setRow(Integer.parseInt(seatNumbers[0]));
							this.setCol(Integer.parseInt(seatNumbers[1]));
							String seats = this.row+","+this.col;
							
							if(checkRow(this.row)||checkCol(this.col)) {
								System.out.println("존재하지 않는 좌석 입니다.");
							}else {
								if(checkSeats()) {
									System.out.println("이미 사용중인 좌석입니다.");
									printSeats();
								}else {
									try {
										sql = "INSERT INTO SEATS (ID) VALUES (?)";
										pstmt = con.prepareStatement(sql);
										pstmt.setString(1, id);
										pstmt.executeUpdate();
										sql1 = "UPDATE SEATS SET SEATS = ? WHERE ID = ?";
										pstmt = con.prepareStatement(sql1);
										pstmt.setString(1, seatNum);
										pstmt.setString(2, id);
										pstmt.executeUpdate();
									} catch (SQLException e) {
										e.printStackTrace();
									}
									List<String> selectSeats = getSeats().get(this.row-1);
									selectSeats.set(this.col-1, "★");
									System.out.println(row+"번째 줄 "+col+"번째 좌석에 사용을 시작합니다.");
									printSeats();
									Runnable r = new Timer(id,seatNum,min);
									Thread t = new Thread(r);
									t.start();
									break;
								}
							}
							
						}
					}else {
						System.out.println("잔액이 부족합니다.");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case 4 :
			min = 10;
			sql = "SELECT BALANCE FROM PCMEMBER WHERE ID = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getInt("BALANCE")>=10000) {
						balance1 = rs.getInt("BALANCE") - 10000;
						String sql1 = "UPDATE PCMEMBER SET BALANCE = ? WHERE ID = ?";
						pstmt = con.prepareStatement(sql1);
						pstmt.setInt(1, balance1);
						pstmt.setString(2, id);
						pstmt.executeUpdate();
						while(true) {
							System.out.println("pc사용할 좌석을 입력해 주세요 ex(x,y : x번째줄 y번째)");
							printSeats();
							
							String seatNum = inputScanner();
							System.out.println("");
							
							seatNum = seatNum.trim();
							seatNum = seatNum.replace(" ", "");
							String seatNumbers[] = seatNum.split(",");
							
							this.setRow(Integer.parseInt(seatNumbers[0]));
							this.setCol(Integer.parseInt(seatNumbers[1]));
							String seats = this.row+","+this.col;
							
							if(checkRow(this.row)||checkCol(this.col)) {
								System.out.println("존재하지 않는 좌석 입니다.");
							}else {
								if(checkSeats()) {
									System.out.println("이미 사용중인 좌석입니다.");
									printSeats();
								}else {
									try {
										sql = "INSERT INTO SEATS (ID) VALUES (?)";
										pstmt = con.prepareStatement(sql);
										pstmt.setString(1, id);
										pstmt.executeUpdate();
										sql1 = "UPDATE SEATS SET SEATS = ? WHERE ID = ?";
										pstmt = con.prepareStatement(sql1);
										pstmt.setString(1, seatNum);
										pstmt.setString(2, id);
										pstmt.executeUpdate();
									} catch (SQLException e) {
										e.printStackTrace();
									}
									List<String> selectSeats = getSeats().get(this.row-1);
									selectSeats.set(this.col-1, "★");
									System.out.println(row+"번째 줄 "+col+"번째 좌석에 사용을 시작합니다.");
									printSeats();
									Runnable r = new Timer(id,seatNum,min);
									Thread t = new Thread(r);
									t.start();
									break;
								}
							}
							
						}
					}else {
						System.out.println("잔액이 부족합니다.");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		}
	}	

	public void foodDB(String id) { //음식주문
		System.out.println("1. 라면(2500원) 2. 블루베리핫치킨피자2조각(3000원) 3. 사이다(2000원)");
		int selectNo = scan.nextInt();
		int balance1 = 0;
		switch(selectNo) {
		case 1:
			String sql = "SELECT BALANCE FROM PCMEMBER WHERE ID = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
				if(rs.getInt("balance")>2500) {
					balance1 = rs.getInt("balance")-2500;
					String sql2 = "UPDATE PCMEMBER SET BALANCE = ? WHERE ID = ?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setInt(1, balance1);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
					System.out.println("라면주문완료");
				} else {
					System.out.println("잔액이 부족합니다");
				}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			sql = "SELECT BALANCE FROM PCMEMBER WHERE ID = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
				if(rs.getInt("balance")>3000) {
					balance1 = rs.getInt("balance")-3000;
					String sql2 = "UPDATE PCMEMBER SET BALANCE = ? WHERE ID = ?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setInt(1, balance1);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
					System.out.println("블루베리핫치킨피자주문완료");
				} else {
					System.out.println("잔액이 부족합니다");
				}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			sql = "SELECT BALANCE FROM PCMEMBER WHERE ID = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
				if(rs.getInt("balance")>2000) {
					balance1 = rs.getInt("balance")-2000;
					String sql2 = "UPDATE PCMEMBER SET BALANCE = ? WHERE ID = ?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setInt(1, balance1);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
					System.out.println("사이다주문완료");
				}else {
					System.out.println("잔액이 부족합니다");
				}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	break;
	
		}
		}
	
	public boolean check2(String id) { // pc사용에서 이미 사용중인 id가 또 다른 좌석에 앉으려할때 중복 id 확인
		boolean check = true;         
		String sql = "SELECT ID FROM SEATS WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("이미 사용중인 유저입니다");
				check = false;
			}else {
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public class Timer implements Runnable { //러너블 인터페이스 사용 다중작업을 위해
		
		String id;
		String seatsNo;
		int min;
		Timer(String id, String seatsNo, int min){ //id seatsNo min 을 받아옴
			this.id = id;
			this.seatsNo = seatsNo;
			this.min = min;
		}

		@Override
		public void run() { // 타이머계산
			int sec = min * 60;
			for(int i = sec; i >= 0; i--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(seatsNo+"번 좌석의 pc사용이 종료되었습니다.");
			String sql = "DELETE FROM SEATS WHERE ID = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String seatNumbers[] = seatsNo.split(",");
			
			setRow(Integer.parseInt(seatNumbers[0]));
			setCol(Integer.parseInt(seatNumbers[1]));
			
			List<String> selectSeats = getSeats().get(row-1);
			selectSeats.set(col-1, "☆");
					
		}
			
	}

}