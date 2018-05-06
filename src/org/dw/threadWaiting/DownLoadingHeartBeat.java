package org.dw.threadWaiting;

public class DownLoadingHeartBeat extends Thread{
	
	private volatile boolean beating = true;
	
	@Override
	public void run() {
		String[] dots = {".","..","...","...."}; 
	
		while (beating) {
			for(String dot: dots) {
				System.out.println(dot);
			}
		}
	}
	
	public void shutdown() {
		this.beating = false;
	}
	
	
	
}
