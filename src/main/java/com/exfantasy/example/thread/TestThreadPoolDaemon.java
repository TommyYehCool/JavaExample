package com.exfantasy.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * http://stackoverflow.com/questions/13883293/turning-an-executorservice-to-daemon-in-java
 * 
 * @author User1
 */
public class TestThreadPoolDaemon {

	public static void main(String[] args) {
		System.out.println("Main thread start...");
		
		System.out.println("Prepare to start some threads with thread pool...");
		
		int threadNums = 2;
		ExecutorService exec = Executors.newFixedThreadPool(threadNums, 
				new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread t = Executors.defaultThreadFactory().newThread(r);
						t.setDaemon(true);
						return t;
					}
				}
		);
		
		for (int i = 0; i < threadNums; i++) {
			exec.execute(new SayHelloTask());
		}
		
		System.out.println("Some threads with thread pool started");
		
		System.out.println("After 3 secs, main thread will end");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main Thread end");
	}

	private static class SayHelloTask implements Runnable {
		
		@Override
		public void run() {
			while (true) {
				System.out.println(">>> SayHelloTask say Hello");
				try {
					Thread.sleep(3000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
