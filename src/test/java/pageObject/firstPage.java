package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class firstPage extends basePage{

	public firstPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
	WebElement user;
	public void users() throws InterruptedException {
		Thread.sleep(5000);
		user.click();
	}	
	
	@FindBy(xpath="//*[@id='mectrl_currentAccount_primary']")
	WebElement name;
	public String namee() throws InterruptedException {
		Thread.sleep(5000);
		return name.getText();
	}
	
	@FindBy(xpath="//*[@id='mectrl_currentAccount_secondary']")
	WebElement mail;
	public String maill() throws InterruptedException {
		Thread.sleep(5000);
		return mail.getText();
	}
	
	@FindBy(xpath="//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']")
	public WebElement aroundCognizant;
	
	@FindBy(xpath="//div[@class='ar_b_91bed31b']//a[@id='news_text_title']")
	public List<WebElement> newsList;
	public List<String> aroundCongnizantNews(){
		List<String> news = new ArrayList<String>();
		for(WebElement e : newsList) {
			news.add(e.getText());
		}
		return news;
	}
	@FindBy(xpath="//*[@id='c24ff0ed-b166-42e5-b7d5-57c9a9e573cb']//p/a[@href]")
	public WebElement seeAll;
	
	public void clickseeAll() {
		seeAll.click();
	}
	
	
}
