package com.exfantasy.example.basic;

import java.math.BigDecimal;

public class TestBigDecimal {
	public static void main(String[] args) {
		double a = 3.454;

		double b = new BigDecimal(a).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("四捨五入到小數點下一位: " + b);
		
		b = new BigDecimal(a).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("四捨五入到整數: " + b);
				
		b = new BigDecimal(a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("四捨五入到小數點下二位: " + b);
	}
}
