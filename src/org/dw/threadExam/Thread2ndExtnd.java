package org.dw.threadExam;

import java.util.concurrent.TimeUnit;

public class Thread2ndExtnd extends Thread {

	
	@Override
    public void run() {
		
		for(int i=0; i<5; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName);
			sleepOneSecond();
		}
		
    }
	
	
	private  void sleepOneSecond() {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
