package testBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class scroll {
	JavascriptExecutor js;
	WebDriver driver;
	public scroll(WebDriver driver)

	{
		this.driver=driver;
	}
	public void Scroll(WebElement ele)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments [0].scrollIntoView();",ele);
	}
}
