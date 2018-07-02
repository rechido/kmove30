package ch18;

public class ThreadExample1 {
	public static void main(String[] args) {
		Thread thread = new DigitThread();
		thread.start();
		for(char ch='a'; ch<='z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
			
		
	}
}

class DigitThread extends Thread{

	@Override
	public void run() {
		super.run();
		for(int cnt=0; cnt<10; cnt++) {
			System.out.println(cnt);
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
			
	}
	
}
