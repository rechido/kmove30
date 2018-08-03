/**
 * 2018. 6. 4. Dev. by D. A. Lee
 */
package ch18;

public class MultithreadExample3 {
	public static void main(String[] args) {
		Thread thread = new Thread(new SmallLetters());
		thread.start();
		char arr[] = {'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
		for(char ch:arr)
			System.out.print(ch);

	}
}

class SmallLetters implements Runnable{

	@Override
	public void run() {
		for(char ch='a'; ch<='z'; ch++) {
			System.out.print(ch);
		}		
	}
	
}
