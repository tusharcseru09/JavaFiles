package org.dw.threadTerminate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class CaseTwo  implements Runnable{
	
	private volatile boolean runnig = true;
	
	public static void main(String[] args) throws InterruptedException {
		CaseTwo watcher = new CaseTwo();
		Thread obj = new Thread(watcher);
		obj.start();
		
		//This sleep will stop Main Thrad execution
		Thread.sleep(TimeUnit.SECONDS.toMillis(200));
		watcher.shutdown();
	}
	
	public void shutdown() {
		this.runnig = false;
	}
	@Override
	public void run() {
		while (runnig) {
			SleepOneSecond();
			PrintCurrentTime();
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
