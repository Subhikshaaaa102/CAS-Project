package testCase;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObject.firstPage;
import pageObject.secondPage;
import testBase.baseClass;
import testBase.scroll;
import utility.ExcelUtility;

public class TC_001_AroundCognizant extends baseClass{
	public static String path;
	List<String> ar=new ArrayList<String>();
	List<String> newsHeader=new ArrayList<String>();
	List<String> newsDesc=new ArrayList<String>();
	
	@Test(priority=1)
	public void verifyAcc() throws InterruptedException {
		try {
			logger.info("********TEST CASE 1 STARTED*********");
			firstPage fp = new firstPage(driver);
			Thread.sleep(5000);
			logger.info("Test case 1 started");
			fp.users();
			logger.info("User info got selected");
			String name = fp.namee();
			String mail = fp.maill();
			System.out.println();
			System.out.println(name+"\n"+mail);
			Assert.assertEquals(name, "Subhiksha, S (Contractor)");
			logger.info("User name Validated Successfully");
			Assert.assertEquals(mail, "2318392@cognizant.com");
			logger.info("Mail Id Validated Successfully");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
			Assert.fail();
		}		
	}
	@Test(priority = 2)
	public void verifyAroundCognizant() throws InterruptedException, IOException {
		System.out.println();
		scroll sc = new scroll(driver);
		firstPage fp = new firstPage(driver);
		try {
			logger.info("********TEST CASE 2 STARTED*********");
			sc.Scroll(fp.aroundCognizant);
			logger.info("Successfully scrolled upto 'AROUND COGNIZANT'");
			Thread.sleep(5000); 
			logger.info("Validating the hearder and tooltip");
			List<WebElement> news = fp.newsList;
			for(WebElement e : news) {
				System.out.println(e.getText());
				ar.add(e.getText());
				if(e.getAttribute("title").equals(e.getText())) {
					Assert.assertTrue(true);
				}else {
					throw new Exception("Validation failed");
				}
			}
			logger.info("Validation successfull");
		}
		catch(Exception e) {
			logger.info(e);
			Assert.fail();
		}
	}
	
	@Test(priority=3)
	public void seeAll() throws IOException { 
		System.out.println();
		scroll sc = new scroll(driver);
		firstPage fp = new firstPage(driver);
		secondPage sp = new secondPage(driver);
		try {
			logger.info("********TEST CASE 3 STARTED*********");
			sc.Scroll(fp.seeAll);
			logger.info("Successfully scrolled upto 'seeAll'");
			Thread.sleep(5000);
			fp.clickseeAll();
			logger.info("See All News section was displayed");
			Thread.sleep(5000);
			logger.info("Validating the hearder and tooltip");
			List<WebElement> news = sp.listHeader;
			for(WebElement e : news) {
				System.out.println(e.getText());
				newsHeader.add(e.getText());
				if(e.getAttribute("title").equals(e.getText())) {
					Assert.assertTrue(true);
				}else {
					throw new Exception("Validation failed");
				}
			}
			logger.info("Validation successfull");
		}
		catch(Exception e) {
			logger.info(e);
			Assert.fail();
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority=4)
	public void newsDetails() throws InterruptedException, IOException {
		System.out.println();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		scroll sc = new scroll(driver);
		for (int i=1;i<6;i++) {
			Thread.sleep(2000);
			WebElement SecondNews = driver.findElement(By.xpath("(//a[@data-automation-id='newsItemTitle'][1])["+i+"]"));
			sc.Scroll(SecondNews);
			
			Thread.sleep(5000);
			String href = SecondNews.getAttribute("href");
			// Open a new tab
			js.executeScript("window.open()");
			// Switch to new tab
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			// Navigate to new URL
			driver.get(href);
			Thread.sleep(5000);
			String News = driver.findElement(By.xpath("//*[@data-automation-id='textBox']")).getText();
			newsDesc.add(News);
			System.out.println(News);
			
			Thread.sleep(5000);
			driver.close();
			
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(5000);
			System.out.println();
		}
		ExcelUtility.output(ar, newsHeader, newsDesc);
		ExcelUtility.closeExcel();
	}
	
}
