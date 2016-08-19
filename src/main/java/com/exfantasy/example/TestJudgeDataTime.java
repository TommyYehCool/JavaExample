package com.exfantasy.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class TestJudgeDataTime {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	private void start() {
		Scanner scanner = new Scanner(System.in);
		
		// 輸入開始時間
		System.out.println("Please input start time (yyyy-MM-dd HH:mm): ");
		Date startTime = null;
		while (startTime == null) {
			startTime = parseInput(scanner.nextLine());
		}
		
		// 取得開始時間的 LocalDate
		LocalDate ldStartTime = startTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		// 取得目前時間減去三個月
		LocalDate ldNowSubstractThreeMonth = LocalDate.now().minus(3, ChronoUnit.MONTHS);
		
		// 若開始時間在目前時間減去三個月前
		if (ldStartTime.isBefore(ldNowSubstractThreeMonth)) {
			System.out.println("Invalid start time (can only be set in three month)");
		}
		else {
			System.out.println("Valid start time");
		}
		scanner.close();
	}
	
	private Date parseInput(String strDate) {
		try {
			return strDate != null ? sdf.parse(strDate) : null;
		} catch (ParseException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		new TestJudgeDataTime().start();
	}
}
