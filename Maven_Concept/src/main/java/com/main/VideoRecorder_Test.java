package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VideoRecorder_Test {

	WebDriver driver;

	@BeforeClass
	void setup() {
		System.setProperty("webdriver.chrome.driver", "C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
	}

	@Test
	void verifyLinks() throws Exception {
		VideoRecorder.startRecord("GoogleTestRecording");//Starting point of video recording
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium"); 
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).click();
                Thread.sleep(3000);
		VideoRecorder.stopRecord();//End point of video recording
	}

	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
}
