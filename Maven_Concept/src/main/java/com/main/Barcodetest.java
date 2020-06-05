package com.main;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

public class Barcodetest {

	@Test()
	public void barcode() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://barcode.tec-it.com/en");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String barCodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(barCodeURL);

		URL url = new URL(barCodeURL);

		BufferedImage buffredimage = ImageIO.read(url);

		com.google.zxing.LuminanceSource luminanceSource = new com.google.zxing.client.j2se.BufferedImageLuminanceSource(
				buffredimage);
		BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

		Result result = new MultiFormatReader().decode(binarybitmap);

		System.out.println(result.getText());

	}

}
