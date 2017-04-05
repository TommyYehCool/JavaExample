package com.exfantasy.example.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestDateBetween {
	public static void main(String[] args) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date start = dateTimeFormat.parse("2017-04-05 15:32:44");
			Date end = dateTimeFormat.parse("2017-04-05 15:32:56");
			System.out.println(start);
			System.out.println(end);
			
			long diff = end.getTime() - start.getTime();
			System.out.println(diff);
			
			System.out.println ("Seconds: " + TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS));
			System.out.println ("Minutes: " + TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS));
			System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
