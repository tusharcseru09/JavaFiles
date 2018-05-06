package org.dw.threadWaiting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ThrdWaiting extends Thread{

	@Override
    public void run() {
		SleepOneSecond();
		
		PrintCurrentTime();
		
		SleepOneSecond();
	}
	
	public void PrintCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:s a");
		String currentTime = LocalDateTime.now().format(formatter);
		System.out.println(currentTime);
	}
	
	public void SleepOneSecond() {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		for(int i = 0 ; i<999; i++) {
			System.out.println(i);
		}*/
	}
	
	
	public static void main(String[] args) {
		ThrdWaiting obj = new ThrdWaiting();
		Thread thrdObj = new Thread(obj);
		thrdObj.start();
		while(thrdObj.isAlive()) {
			
		}
		System.out.println("fjklsadjl");
	}
	
	
	
	
	
	
	
}
