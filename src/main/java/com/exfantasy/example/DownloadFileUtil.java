package com.exfantasy.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.URL;

public class DownloadFileUtil {

	public static void download(String sourceUrl, String destPath) throws IOException, ConnectException {
	    InputStream is = new URL(sourceUrl).openConnection().getInputStream();
	    FileOutputStream fos = new FileOutputStream(destPath);
	    byte[] buffer = new byte[1024];
	    for (int length; (length = is.read(buffer)) > 0; fos.write(buffer, 0, length));
	    fos.close();
	    is.close();
	}
}
