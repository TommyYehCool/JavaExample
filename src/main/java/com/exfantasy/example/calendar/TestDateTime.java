package com.exfantasy.example.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TestDateTime {
	private void start() {
		getTodaysDate();
		
		getCurrentDayMonthYear();
		
		getParticularDate();
		
		checkTwoDateAreEqual();
		
		checkIsBirthday();
		
		getCurrentTime();
		
		addHoursInTime();
		
		findNextWeekDate();
		
		calculateDaysBetween();
		
		calculateMonthsBetween();
		
		testDate();
	}

	private void getTodaysDate() {
		LocalDate dateOfToday = LocalDate.now();
		System.out.println("Today's local date: " + dateOfToday);
	}

	private void getCurrentDayMonthYear() {
		LocalDate dateOfToday = LocalDate.now();
		int year = dateOfToday.getYear();
		int month = dateOfToday.getMonthValue();
		int day = dateOfToday.getDayOfMonth();
		System.out.printf("Year: %d, Month: %d, Day: %d \t %n", year, month, day);
	}

	private void getParticularDate() {
		LocalDate dateOfBirth = LocalDate.of(1980, 11, 12);
		System.out.println("My birthday is " + dateOfBirth);
	}

	private void checkTwoDateAreEqual() {
		LocalDate dateOfToday = LocalDate.now();
		LocalDate testDate = LocalDate.of(2015, 3, 19);
		if (testDate.equals(dateOfToday)) {
			System.out.printf("Today %s and testDate %s are same date %n", dateOfToday, testDate);
		}
	}

	private void checkIsBirthday() {
		LocalDate dateOfBirth = LocalDate.of(1980, 11, 12);
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		
		LocalDate dateOfToday = LocalDate.now();
		MonthDay currentMonthDay = MonthDay.from(dateOfToday);
		
		if (currentMonthDay.equals(birthday)) {
			System.out.println("Happy Birthday to you~~~");
		}
		else {
			System.out.printf("Today: %s is not your birthday: %s %n", dateOfToday, dateOfBirth);
		}
	}

	private void getCurrentTime() {
		LocalTime time = LocalTime.now();
		System.out.println("Local time now: " + time);
	}

	private void addHoursInTime() {
		LocalTime time = LocalTime.now();
		LocalTime newTime = time.plusHours(2);
		System.out.println("Time after 2 hours: " + newTime);
	}

	private void findNextWeekDate() {
		LocalDate today = LocalDate.now();
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Date after 1 week: " + nextWeek);
	}

	private void calculateDaysBetween() {
		LocalDate today = LocalDate.now();
		LocalDate goDate = LocalDate.of(2016, Month.FEBRUARY, 29);
		Period period = Period.between(today, goDate);
		
		long totalDays = ChronoUnit.DAYS.between(today, goDate);
		
		System.out.printf("Remain %d months and %d days, total: %d days %n", period.getMonths(), period.getDays(), totalDays);
	}
	
	private void calculateMonthsBetween() {
		LocalDate start = LocalDate.of(1980, 11, 12);
		LocalDate end = LocalDate.of(2017, 3, 29);
		long totalMonths = ChronoUnit.MONTHS.between(start, end);
		System.out.printf("Total month: %d %n", totalMonths);
		
		long totalYears = totalMonths / 12;
		long remainMonths = totalMonths % 12;
		System.out.printf("Total year month: %d years %d months %n", totalYears, remainMonths);
	}

	private void testDate() {
		String input = "2016-08-09 10:00:00";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date parse = df.parse(input);
			parse.setTime(parse.getTime() * 1000);
			System.out.printf("Test date, time: %d, String: %s%n", parse.getTime(), parse.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date date = new Date();
		System.out.printf("Test new Date(), time: %d, String: %s%n", date.getTime(), date.toString());
		
		long time = date.getTime();
		long timeToSet = time * 1000;
		date.setTime(timeToSet);
		
		System.out.printf("Test date setTime, time: %d, String: %s%n", timeToSet, date.toString());
	}

	public static void main(String[] args) {
		new TestDateTime().start();
	}
}
