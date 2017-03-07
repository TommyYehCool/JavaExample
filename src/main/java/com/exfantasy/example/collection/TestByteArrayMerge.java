package com.exfantasy.example.collection;

import java.util.ArrayList;
import java.util.List;

public class TestByteArrayMerge {

	public static void main(String[] args) {
		List<byte[]> dataBuffer = new ArrayList<>();
		
		byte[] bHello = "Hello".getBytes();
		byte[] bWorld = " World".getBytes();
		byte[] bTommy = " Tommy".getBytes();
		byte[] bLove = " Love".getBytes();
		byte[] bYou = " You".getBytes();
		
		System.out.println("\"Hello\" length: " + bHello.length);
		System.out.println("\" World\" length: " + bWorld.length);
		System.out.println("\" Tommy\" length: " + bTommy.length);
		System.out.println("\" Love\" length: " + bLove.length);
		System.out.println("\" You\" length: " + bYou.length);
		
		dataBuffer.add(bHello);
		dataBuffer.add(bWorld);
		dataBuffer.add(bTommy);
		dataBuffer.add(bLove);
		dataBuffer.add(bYou);
		
		int totalLen = 0;
		for (int i = 0; i < dataBuffer.size(); i++) {
			totalLen += dataBuffer.get(i).length;
		}
		
		int pos = 0;
		byte[] bData = new byte[totalLen];
		
		System.out.println();
		System.out.println();
		System.out.println("bData length: " + bData.length);
		
		for (int i = 0; i < dataBuffer.size(); i++) {
			System.arraycopy(dataBuffer.get(i), 0, bData, pos, dataBuffer.get(i).length);
			pos += dataBuffer.get(i).length;
		}
		
		System.out.println("\"" + new String(bData) + "\"");
	}

}
