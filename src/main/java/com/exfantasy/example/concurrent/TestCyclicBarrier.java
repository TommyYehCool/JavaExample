package com.exfantasy.example.concurrent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <pre>
 * 參考網站
 * <a href="http://www.cnblogs.com/dolphin0520/p/3920397.html">http://www.cnblogs.com/dolphin0520/p/3920397.html</a>
 * </pre>
 * 
 * @author TommyYeh
 */
public class TestCyclicBarrier {
	public static void main(String[] args) {
		int counts = 4;
		CyclicBarrier barrier = new CyclicBarrier(counts);
		for (int i = 0; i < counts; i++)
			new Writer(i, barrier).start();
	}

	static class Writer extends Thread {
		private SimpleDateFormat mTimeFormat = new SimpleDateFormat("HH:mm:ss");
		private CyclicBarrier cyclicBarrier;
		private int sleepTime = 1000;

		public Writer(int threadIndex, CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
			this.sleepTime = this.sleepTime * (threadIndex + 1);
		}

		@Override
		public void run() {
			System.out.println(getCurrentTime() + "Thread: " + Thread.currentThread().getName() + " 正在寫入數據, sleepTime: " + sleepTime);
			try {
				Thread.sleep(this.sleepTime); // 以睡眠來模擬寫入數據操作
				System.out.println(getCurrentTime() + "Thread: " + Thread.currentThread().getName() + " 寫入數據完畢，等待其他線程寫入完畢");
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println(getCurrentTime() + "所有 Thread 寫入完畢，Thread: " + Thread.currentThread().getName() + " 繼續處理其他任務...");
		}
		
		private String getCurrentTime() {
			return "<" + mTimeFormat.format(Calendar.getInstance().getTime()) + "> ";
		}
	}
}