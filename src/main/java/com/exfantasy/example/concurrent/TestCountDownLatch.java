package com.exfantasy.example.concurrent;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(2);

		new Thread() {
			public void run() {
				try {
					System.out.println("Thread: " + Thread.currentThread().getName() + "正在執行");
					Thread.sleep(3000);
					System.out.println("Thread: " + Thread.currentThread().getName() + "執行完畢");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

		new Thread() {
			public void run() {
				try {
					System.out.println("Thread: " + Thread.currentThread().getName() + "正在執行");
					Thread.sleep(3000);
					System.out.println("Thread: " + Thread.currentThread().getName() + "執行完畢");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

		try {
			System.out.println("等待 2 個 Thread 執行完畢...");
			latch.await();
			System.out.println("2 個 Thread 已經執行完畢");
			System.out.println("繼續執行主線程");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}