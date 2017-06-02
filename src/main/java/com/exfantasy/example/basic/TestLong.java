package com.exfantasy.example.basic;

public class TestLong {
	public static void main(String[] args) {
		long secs = Long.MAX_VALUE / 1000;
		System.out.println("Seconds: " + secs);
		
		long minutes = secs / 60;
		System.out.println("Minutes: " + minutes);
		
		long hours = minutes / 60;
		System.out.println("Hours: " + hours);
		
		long days = hours / 24;
		System.out.println("Days: " + days);
		
		long months = days / 30;
		System.out.println("Months: " + months);
		
		long years = months / 12;
		System.out.println("Years: " + years);
	}
}
