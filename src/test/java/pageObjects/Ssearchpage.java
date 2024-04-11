package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ssearchpage extends BasePage
{   
	WebDriver driver;
	
	public Ssearchpage(WebDriver driver)
	{
		super(driver);
	}	
	
		@FindBy(xpath = "//input[@placeholder='Search']")
		WebElement searchp;
		@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
		WebElement productclick;
		@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
		WebElement click;
		@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
		WebElement cnfMsg;
		public void product(String pro)
		{
			searchp.sendKeys(pro);
		}
		public void pclick() {
			productclick.click();
		}
		public void cclick() {
			click.click();
		}
		public boolean checkConfMsg()
		{
			try
			{
			return cnfMsg.isDisplayed();
			}
			catch(Exception e)
			{
				return false;
			}
		}
}
