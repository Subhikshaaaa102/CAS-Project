package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseClass {
	protected static WebDriver driver;
	public JavascriptExecutor js;
	protected  Logger logger;
	public Properties prop;
	public static TakesScreenshot ts;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String n) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\2318392\\eclipse-workspace\\CASProject\\src\\test\\resources\\dataproperty.properties");
		prop = new Properties();
		prop.load(fis);
		fis.close();
		
		logger = LogManager.getLogger(this.getClass());
		
		if(n.toLowerCase().equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(n.toLowerCase().equals("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("appURL"));
		ts=(TakesScreenshot)driver;
		
		driver.manage().window().maximize();
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	public static String getScreenshot(String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Screenshot\\" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		sourceFile.renameTo(destination);
		
		return path;
	}

}
