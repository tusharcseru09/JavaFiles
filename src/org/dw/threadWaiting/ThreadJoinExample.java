package org.dw.threadWaiting;

public class ThreadJoinExample {
	
	public static void main(String[] args) {
		
		FileDownLoader dl1 = new FileDownLoader("https://goo.gl/nqZJn4", "first.jpeg");
		FileDownLoader dl2 = new FileDownLoader("https://goo.gl/UoSMMt", "second.jpeg");
		
		DownLoadingHeartBeat heartBeat = new DownLoadingHeartBeat();
		
		dl1.start();
		dl2.start();
		heartBeat.start();
		
		try {
			dl1.join();
			dl2.join();
			heartBeat.shutdown();
			heartBeat.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Download complete.");
	}

}
