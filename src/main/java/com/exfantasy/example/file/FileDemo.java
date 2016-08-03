package com.exfantasy.example.file;

import java.io.File;
import java.text.DecimalFormat;

public class FileDemo {
	private static int KB = 1024;
	private static int MB = KB * 1024;
	private static int GB = MB * 1024;
	private static DecimalFormat format = new DecimalFormat("###,###");
	
	public static void main(String[] args) {
		System.out.printf("KB: %d bytes, MB: %d bytes, GB: %d bytes %n", KB, MB, GB);
		
		File[] roots = File.listRoots();
		for (File root : roots) {
			long totalSpace = root.getTotalSpace();
			long usableSpace = root.getUsableSpace();
			System.out.printf("%s 總容量: %d GB (%s bytes)，可用容量: %d GB (%s bytes)%n", root.getPath(), totalSpace / GB, format.format(totalSpace), usableSpace / GB, format.format(usableSpace));
		}
	}
}