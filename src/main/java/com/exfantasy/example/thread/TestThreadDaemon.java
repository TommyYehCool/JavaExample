package com.exfantasy.example.thread;

/**
 * 說明:
 *
 * testThread.setDaemon(false);
 *
 * 		main thread 跑完了, thread 會繼續跑
 *
 * testThread.setDaemon(true);
 *
 * 		main thread 跑完了, thread 就停止
 *
 */
public class TestThreadDaemon {

	public static void main(String[] args) {
		System.out.println("Main thread start...");
		
		System.out.println("Prepare to start a Thread...");
		
		Thread testThread = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(">>> Thread running");
				}
			}
		};
		testThread.setDaemon(true);
		testThread.start();
		
		System.out.println("Thread started");
		
		System.out.println("After 3 secs, main thread will end");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main Thread end");
	}
}