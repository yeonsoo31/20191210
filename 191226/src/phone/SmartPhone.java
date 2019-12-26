package phone;

public class SmartPhone extends PDA implements MP3, Mobile {

	@Override
	public void keyPad() {
		System.out.println("┌────────┬────────┬────────┐");
		System.out.println("│ 1 ㄱㅋ  │ 2   ㄴ  │ 3 ㄷㅌ   │");
		System.out.println("│  .QZ   │   ABC  │   DEF  │");
		System.out.println("├────────┼────────┼────────┤");
		System.out.println("│ 4   ㄹ  │ 5   ㅁ  │ 6 ㅂㅍ  │");
		System.out.println("│   GHI  │   JKL  │   MNO  │");
		System.out.println("├────────┼────────┼────────┤");
		System.out.println("│ 7   ㅅ  │ 8   ㅇ  │ 9 ㅈㅊ  │");
		System.out.println("│   PRS  │   TUV  │   XYZ  │");
		System.out.println("├────────┼────────┼────────┤");
		System.out.println("│ *      │ 0   ㅎ  │ #      │");
		System.out.println("│   ,    │    +   │    ;   │ ");
		System.out.println("└────────┴────────┴────────┘");
		
	}

	@Override
	public void call() {
		System.out.println("전화 발신");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("전화 수신");
		
	}

	@Override
	public void sendMessage() {
		System.out.println("메세지 발신");
		
	}

	@Override
	public void receiveMessage() {
		System.out.println("메세지 수신");
		
	}

	@Override
	public void play() {
		System.out.println("음악 재생");
		
	}

	@Override
	public void stop() {
		System.out.println("음악 정지");
		
	}

	
	
	
}
