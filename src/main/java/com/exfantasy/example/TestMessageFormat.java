package com.exfantasy.example;

import java.text.MessageFormat;

public class TestMessageFormat {

	public static void main(String[] args) {
		String str = "{0}{1}{2}{3}{4}{5}{6}{7}{8}{9}{10}{11}{12}{13}{14}{15}{16}";  
		Object[] array = new Object[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"};  
		String value = MessageFormat.format(str, array);  
		System.out.println(value); // ABCDEFGHIJKLMNOPQ  
	}

}
