package project2;

public class Runnable01 implements Runnable {
	private int min = 2;
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	@Override
	public void run() {	
		int min = 2;
		int sec = min * 60;
		for(int i = sec; i >=0 ; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	}
}
