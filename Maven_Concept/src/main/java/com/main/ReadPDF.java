package com.main;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadPDF {

	@Test()
	public void reaTestdPDF() throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

	//	driver.get("http://www.africau.edu/images/default/sample.pdf");
		Thread.sleep(5000);
		
		/* if user wants to read file from system 2 ways
			1. Enter file path in driver.get
			2. Enter file path in new URL("file path")
		*/
		driver.get("file:///C://Users//Shubhada//Downloads//3762 Accounting Make Validation incorrect (1).pdf");
		String currentUrl = driver.getCurrentUrl();
		
		URL url = new URL(currentUrl);
		//second method : URL url = new URL(file:///C://Users//Shubhada//Downloads//3762 Accounting Make Validation incorrect (1).pdf);
		
		InputStream is = url.openStream();
		
		BufferedInputStream fileparse = new BufferedInputStream(is);
		
		PDDocument document = null;
		
		document = PDDocument.load(fileparse);
		
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		
		Assert.assertTrue(pdfContent.contains("zzzzz"));
		Assert.assertTrue(pdfContent.contains("Continued on page 2"));
		Assert.assertTrue(pdfContent.contains("The end, and just as well."));
	}
	
	
}
