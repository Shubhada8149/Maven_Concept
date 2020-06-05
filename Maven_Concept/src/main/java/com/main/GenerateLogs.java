package com.main;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenerateLogs {

	public static void main(String[] args) {

		
		Logger log = Logger.getLogger(GenerateLogs.class);
		
		System.setProperty("webdriver.chrome.driver","C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		log.info("launching browser");
		
		driver.get("http://www.google.com");
		log.info("google url has been launched");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		log.info("title is" + title);
			
	}

}
