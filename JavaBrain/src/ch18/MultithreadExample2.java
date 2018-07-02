/**
 * 2018. 6. 4. Dev. by D. A. Lee
 */
package ch18;

public class MultithreadExample2 {
	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new DigitThread();
		Thread thread3 = new AlphabetThread();
		thread1.start();
		thread2.start();
		thread3.start();

	}

}

class AlphabetThread extends Thread{

	@Override
	public void run() {
		super.run();
		for(char ch='a'; ch<='z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(500);
			}catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
