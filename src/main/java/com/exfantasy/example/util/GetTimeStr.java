package com.exfantasy.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetTimeStr {
	private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static String promoEnableTime 		= "2017-05-19 17:58:00";
	private static String startTime 			= "2017-05-19 17:58:05";
	private static String endTime 				= "2017-05-19 18:03:00";
	private static String promoAuditEndTime 	= "2017-05-30 23:00:00";
	private static String promoGoldTime			= "2017-05-31 23:00:00";
	
	private static void auto() throws ParseException {
		// 上架時間
		Date dPromoEnableTime = f.parse(promoEnableTime);
		
		// 開始時間 = 上架時間 + 5秒
		Calendar cal = Calendar.getInstance();
		cal.setTime(dPromoEnableTime);
		cal.add(Calendar.SECOND, 5);
		Date dStartTime = cal.getTime();

		// 結束時間 = 上架時間 + 1分鐘
		cal.setTime(dPromoEnableTime);
		cal.add(Calendar.MINUTE, 1);
		Date dEndTime = cal.getTime();
		
		// 審核截止時間
		Date dPromoAuditEndTime = f.parse(promoAuditEndTime);
		
		// 派獎時間
		Date dPromoGoldTime = f.parse(promoGoldTime);
		
		show(true, dPromoEnableTime, dStartTime, dEndTime, dPromoAuditEndTime, dPromoGoldTime);
	}

	private static void specific() throws ParseException {
		// 上架時間
		Date dPromoEnableTime = f.parse(promoEnableTime);
		
		// 開始時間
		Date dStartTime = f.parse(startTime);
		
		// 結束時間
		Date dEndTime = f.parse(endTime);
		
		// 審核截止時間
		Date dPromoAuditEndTime = f.parse(promoAuditEndTime);
		
		// 派獎時間
		Date dPromoGoldTime = f.parse(promoGoldTime);
		
		show(false, dPromoEnableTime, dStartTime, dEndTime, dPromoAuditEndTime, dPromoGoldTime);
	}
	
	private static void show(boolean isAuto, Date dPromoEnableTime, Date dStartTime, Date dEndTime, Date dPromoAuditEndTime, Date dPromoGoldTime) {
		System.out.println(isAuto ? "----- Auto -----" : "----- Specific -----");
		
		long lPromoEnableTime = dPromoEnableTime.getTime() / 1000;
		long lStartTime = dStartTime.getTime() / 1000;
		long lEndTime = dEndTime.getTime() / 1000;
		long lPromoAuditEndTime = dPromoAuditEndTime.getTime() / 1000;
		long lPromoGoldTime = dPromoGoldTime.getTime() / 1000;
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("\"promoEnableTime\": ").append(lPromoEnableTime).append(",\n");
		buffer.append("\"startTime\": ").append(lStartTime).append(",\n");
		buffer.append("\"endTime\": ").append(lEndTime).append(",\n");
		buffer.append("\"promoAuditEndTime\": ").append(lPromoAuditEndTime).append(",\n");
		buffer.append("\"promoGoldTime\": ").append(lPromoGoldTime).append(",");
		
		System.out.println(buffer.toString());
	}

	public static void main(String[] args) throws ParseException {
		auto();
		
		specific();
	}
}
