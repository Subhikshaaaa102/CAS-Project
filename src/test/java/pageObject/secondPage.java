package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class secondPage extends basePage{

	public secondPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@data-automation-id='newsItemTitle']")
	public List<WebElement> listHeader;  
	public List<String> listHeader() {
		List<String> news = new ArrayList<String>();
		for(WebElement e : listHeader) {
			news.add(e.getText());
		}
		return news;
	}

}
