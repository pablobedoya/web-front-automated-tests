package automation.webfront.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	protected WebDriver driver;
    
    public BasePage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public WebDriver getDriver() {
    	return driver;
    }
    
    public void navigateTo(String url) {
		driver.navigate().to(url);
	}
    
    public void closeBrowser() {
		driver.close();
	}

}
