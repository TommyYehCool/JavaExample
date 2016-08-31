package com.exfantasy.example.sysprop;

import java.util.Properties;

public class TestSystemProperty {
	public static void main(String[] args) {
		System.setProperty("TommyVariable", "haha");

		Properties properties = System.getProperties();
		properties.list(System.out);
	}
}
