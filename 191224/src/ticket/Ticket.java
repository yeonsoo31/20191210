package ticket;

public class Ticket {
	
	int ticketNum;
	double ticketPrice;
	
	Ticket(int ticketNum, double ticketPrice){
		this.ticketNum = ticketNum;
		this.ticketPrice = ticketPrice;
	}
	
	// 티켓가격 출력을 위한 메소드
	
	double getTicketPrice() {
		return ticketPrice;
	}
	
}
