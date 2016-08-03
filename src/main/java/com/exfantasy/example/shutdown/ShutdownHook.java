package com.exfantasy.example.shutdown;

public class ShutdownHook {
	
	private void showProcessName() {
		String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("ProcessName: " + processName);
		
		long processID = Long.parseLong(processName.split("@")[0]);
		System.out.println("Process ID: " + processID);
	}

	private void addShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println(">>>>> Inside shutdown hook <<<<<");
			}
		});
		System.out.println("Shutdown hook attached");
	}
	
	private void runForever() {
		InfiniteThread thread = new InfiniteThread();
		thread.setDaemon(false);
		thread.start();
	}
	
	public static void main(String[] args) {
		ShutdownHook hook = new ShutdownHook();
		hook.showProcessName();
		hook.addShutdownHook();
		hook.runForever();
		
		System.out.println("After 5000 ms call System exit");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/**
		 * http://stackoverflow.com/questions/12404712/java-shutdown-hook-not-run
		 * 
		 * When you call System.exit() or terminate via a signal, it stop all the existing threads and starts all the shutdown hooks
		 */
		System.exit(0);
	}
	
	private class InfiniteThread extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("Thread running");
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
