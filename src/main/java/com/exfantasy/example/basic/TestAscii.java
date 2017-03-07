package com.exfantasy.example.basic;

import java.util.Scanner;

public class TestAscii {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Input a ascii code to show mapping symbol:");
			int input = scanner.nextInt();
			if (input == -1) {
				System.out.println("Bye");
				break;
			}
			char ascii = (char) input;
			System.out.println("Ascii: " + input + ", symbol: " + ascii);
		}
		scanner.close();
	}
}
