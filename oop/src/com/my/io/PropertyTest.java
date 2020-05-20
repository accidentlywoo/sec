package com.my.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyTest {
	public static void main(String[] args) {
		String devName, devVer, devDate;
		Properties env;
		env = new Properties();
		try {
			env.load(new FileInputStream("a.properties"));
			devName = env.getProperty("developer");
			devVer = env.getProperty("ver");
			devDate = env.getProperty("dt");
			
			System.out.println(devName +", "+ devVer +", "+ devDate);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
