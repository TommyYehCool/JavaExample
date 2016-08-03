package com.exfantasy.example.systemtray;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.net.URL;

public class SystemTrayDemo {
	public static void main(String[] args) {
		if (SystemTray.isSupported()) {
			
			URL resource = SystemTrayDemo.class.getResource("/res/FlowerFire.png");
			Image image = Toolkit.getDefaultToolkit().getImage(resource);

			final PopupMenu popup = new PopupMenu();
			
			final TrayIcon trayIcon = new TrayIcon(image, "Mario");
			trayIcon.setImageAutoSize(true);

			final SystemTray tray = SystemTray.getSystemTray();
			
			// Create a pop-up menu components
	        MenuItem aboutItem = new MenuItem("About");
	        CheckboxMenuItem cb1 = new CheckboxMenuItem("Set auto size");
	        CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");

	        Menu displayMenu = new Menu("Display");
	        MenuItem errorItem = new MenuItem("Error");
	        MenuItem warningItem = new MenuItem("Warning");
	        MenuItem infoItem = new MenuItem("Info");
	        MenuItem noneItem = new MenuItem("None");
	        MenuItem exitItem = new MenuItem("Exit");
	       
	        // Add components to pop-up menu
	        popup.add(aboutItem);
	        popup.addSeparator();
	        popup.add(cb1);
	        popup.add(cb2);
	        popup.addSeparator();
	        popup.add(displayMenu);
	        displayMenu.add(errorItem);
	        displayMenu.add(warningItem);
	        displayMenu.add(infoItem);
	        displayMenu.add(noneItem);
	        popup.add(exitItem);
	        
	        trayIcon.setPopupMenu(popup);

			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println("無法加入系統工具列圖示");
				e.printStackTrace();
			}
		} else {
			System.err.println("無法取得系統工具列");
		}
	}
}