package com.exfantasy.example.lambda;

public class TestThreadLambda {
	private void start() {
		testThread();
	}
	
	private void testThread() {
		// Old
		new Thread(new Runnable() {
			@Override
			public void run() {
				printMsg("Old Thread damn~~~~");
			}
		}).start();
		
		// New
		new Thread(() -> printMsg("New Thread Rock~~~~")).start();
	}
	
	private void printMsg(String msg) {
		for (int i = 0; i < 2; i++) {
			System.out.println(msg);
		}
	}

	public static void main(String[] args) {
		new TestThreadLambda().start();
	}
}
