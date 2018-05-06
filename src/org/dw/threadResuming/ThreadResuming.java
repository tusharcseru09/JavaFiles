package org.dw.threadResuming;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ThreadResuming extends Thread{
	
	public volatile boolean keepWatching = true;
	public volatile Integer count = 0;
	
	@Override
    public void run() {
		
		while(keepWatching) {
			PrintCurrentTime();
			
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis(1));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
    }
	
	public void PrintCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:s a");
		String formattedCurrentTime = LocalDateTime.now().format(formatter);
		System.out.println(formattedCurrentTime);
		count ++;
	}
	
	public void TerminateThread () {
		this.keepWatching = false;
	}
	
	public static void main(String[] args) {
		ThreadResuming obj = new ThreadResuming();
		Thread thrdObj = new Thread(obj);
		thrdObj.start();
		/*
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(60));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		obj.TerminateThread();
		*/
		while(thrdObj.isAlive()) {
			if (obj.count > 60) {
				obj.TerminateThread();
			}
		}
		
		
	}

	
}
