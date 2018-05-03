package org.dw.threadTerminate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class CaseOne implements Runnable{
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread obj = new Thread(new CaseOne());
		obj.start();
		
		Thread.sleep(TimeUnit.SECONDS.toMillis(10));
		obj.interrupt();
	}
	@Override
	public void run() {
		while (true) {
			//SleepOneSecond();
			PrintCurrentTime();
			if (Thread.interrupted()) {
				System.out.println("Thread is interrupted");
				return;
			}
		}
		
	}
	public void SleepOneSecond() {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void PrintCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:s a");
		String formattedCurrentTime = LocalDateTime.now().format(formatter);
		System.out.println(formattedCurrentTime);
	}

}
