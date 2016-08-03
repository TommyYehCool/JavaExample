package com.exfantasy.example.lambda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.temporal.ChronoUnit;

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
		
		System.out.printf("Remain %d months and %d days, total: %d days %n ", period.getMonths(), period.getDays(), totalDays);
	}

	public static void main(String[] args) {
		new TestDateTime().start();
	}
}
