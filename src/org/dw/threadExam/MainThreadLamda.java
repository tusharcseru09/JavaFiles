package org.dw.threadExam;

import java.util.concurrent.TimeUnit;

public class MainThreadLamda {

	private static  void sleepOneSecond() {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		//anonymous
		Thread trdObj = new Thread( new Runnable() {
				@Override
				public void run() {
					for(int i=0; i<5; i++) {
						String threadName = Thread.currentThread().getName();
						System.out.println(threadName);
						sleepOneSecond();
					}
				}
		});
		
		trdObj.setName("simple name");
		trdObj.start();
		

		//Lamda Expression
		Thread trdObj2 = new Thread ( ()-> {
				for(int i=0; i<5; i++) {
					String threadName = Thread.currentThread().getName();
					System.out.println(threadName);
					sleepOneSecond();
				}	
		});
		
		trdObj2.setName("Hello");
		trdObj2.start();
	
		
		
		
	}//End Main Method
	
	
	
	
	
}
