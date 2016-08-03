package com.exfantasy.example.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimerDaemon {

	public static void main(String[] args) {
		System.out.println("Main thread start...");

		long interval = 5000;

		System.out.println("Prepare to schedule a TimerTask, after " + (interval / 1000) + " sec, every " + (interval / 1000) + " secs will say Hello...");

		// set Timer daemon to true
		Timer timer = new Timer(true);
		SayHelloTask sayHelloTask = new SayHelloTask();
		timer.schedule(sayHelloTask, interval, interval);
		
		System.out.println("TimerTask scheduled");
		
		System.out.println("After 10 secs, main thread will end");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main thread ended");
	}
	
	public static class SayHelloTask extends TimerTask {
		@Override
		public void run() {
			System.out.println(">>> SayHelloTask say Hello");
		}
		
	}
}
