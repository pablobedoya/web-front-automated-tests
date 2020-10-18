package automation.webfront.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.webfront.config.ConfigProperties;
import lombok.Getter;

@Getter
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private static final String LOGIN_PATH = "?controller=authentication";

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement submitLogin;
	
	@FindBy(id="email_create")
	private WebElement emailCreate;

	@FindBy(id = "SubmitCreate")
	private WebElement submitCreate;
	
	@FindBy(xpath = "//div[@id=\"center_column\"]/p")
	private WebElement welcomeMessage;

	@FindBy(xpath = "//div[contains(@class, 'alert-danger')]//li")
	private WebElement alertDanger;

	public void navigateToLoginPage() {
		navigateTo(ConfigProperties.getInstance().getBaseUrl() + LOGIN_PATH);
	}

	public void fillEmail(String email) {
		this.email.sendKeys(email);
	}

	public void fillPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickSubmit() {
		submitLogin.click();
	}
	
	public void fillEmailCreate(String email) {
		this.emailCreate.sendKeys(email);
	}

	public void clickSubmitCreate() {
		submitCreate.click();
	}

	public void login(String email, String password) {
		fillEmail(email);
		fillPassword(password);
		clickSubmit();
	}

}
