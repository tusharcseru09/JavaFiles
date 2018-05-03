package org.dw.threadCreate;

public class MainThread {
	
	public static void main(String[] args) {
		/*
		Thread1stExtnd threadObj1 = new Thread1stExtnd();
		threadObj1.setName("First thread 01");
		threadObj1.start();
		
		
		Thread2ndExtnd threadObj2 = new Thread2ndExtnd();
		threadObj2.setName("Second thread 02");
		threadObj2.start();
		*/
		
		Thread1stImp threadObj1 = new Thread1stImp();
		Thread mstThread1 = new Thread(threadObj1);
		mstThread1.setName("First thread 01");
		mstThread1.start();
		
		
		Thread2ndImp threadObj2 = new Thread2ndImp();
		Thread mstThread2 = new Thread(threadObj2);
		mstThread2.setName("Second thread 02");
		mstThread2.start();
		
		
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + ", " + currentThread.getId() + ", " + currentThread.getPriority());
	}

}
