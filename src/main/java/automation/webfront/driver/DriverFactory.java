package automation.webfront.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class DriverFactory {
	
	public WebDriver createInstance(String browser) {
    	DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
    	
    	switch (driverManagerType) {
    		case CHROME:
    			ChromeDriverManager.getInstance(driverManagerType).setup();
    			return new ChromeDriver(new ChromeOptions().setHeadless(true));
    		case FIREFOX:
    			FirefoxDriverManager.getInstance(driverManagerType).setup();
    			return new FirefoxDriver(new FirefoxOptions().setHeadless(true));
    		case EDGE:
    			EdgeDriverManager.getInstance(driverManagerType).setup();
    			return new EdgeDriver();
    		case OPERA:
    			OperaDriverManager.getInstance(driverManagerType).setup();
    			return new OperaDriver();
			default:
				throw new RuntimeException("The configuration of the selected browser is not supported.");
    	}
    }
	
}
