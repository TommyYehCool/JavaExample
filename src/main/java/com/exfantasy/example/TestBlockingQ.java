package com.exfantasy.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestBlockingQ {
	
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
	private LinkedBlockingQueue<String> mReadyGwIds = new LinkedBlockingQueue<String>();
	
	private void start() {
		while (true) {
			System.out.println(timeFormat.format(Calendar.getInstance().getTime()) + " Prepare to get string from queue...");
			try {
				String got = mReadyGwIds.poll(5, TimeUnit.SECONDS);
				System.out.println(timeFormat.format(Calendar.getInstance().getTime()) + " Get string from queue: " + got);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new TestBlockingQ().start();
	}
}
