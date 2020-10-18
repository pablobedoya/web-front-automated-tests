package automation.webfront.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import automation.webfront.config.ConfigProperties;
import automation.webfront.data.AccountDataUtil;
import automation.webfront.driver.DriverFactory;
import automation.webfront.model.Account;
import automation.webfront.model.EmailType;
import automation.webfront.model.PasswordType;
import automation.webfront.page.AccountPage;
import automation.webfront.page.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private static final String SUCCESSFUL_LOGIN_MESSAGE = "Welcome to your account. Here you can manage all of your personal information and orders.";
	
	private DriverFactory driverFactory = new DriverFactory();
	private LoginPage loginPage = new LoginPage(driverFactory.createInstance(ConfigProperties.getInstance().getBrowser()));
	private AccountPage accountPage;
	private Account account;

	@Given("I successfully registered on the website")
	public void i_successfully_registered_on_the_website() {
		account = AccountDataUtil.generateAccount();
		accountPage = new AccountPage(loginPage.getDriver());
		
		loginPage.navigateToLoginPage();
		loginPage.fillEmailCreate(account.getEmail());
		loginPage.clickSubmitCreate();
		
		accountPage.fillAllAccountData(account);
		accountPage.clickSubmitAccount();
		accountPage.logout();
	}

	@And("I want to login in website")
	public void i_want_to_login_in_website() {
		loginPage.navigateToLoginPage();
	}

	@And("I enter valid credentials")
	public void i_enter_valid_credentials() {
		loginPage.fillEmail(account.getEmail());
		loginPage.fillPassword(account.getPassword());
	}

	@And("I enter {} email")
	public void i_enter_email(EmailType emailType) {
		loginPage.fillEmail(AccountDataUtil.generateEmailByType(emailType));
	}

	@And("I enter {} password")
	public void i_enter_password(PasswordType passwordType) {
		loginPage.fillPassword(AccountDataUtil.generatePasswordByType(passwordType));
	}

	@When("I submit the login")
	public void i_submit_the_login() {
		loginPage.clickSubmit();
	}

	@Then("should return that the login was successful")
	public void should_return_that_the_login_was_successful() {
		assertThat(loginPage.getWelcomeMessage().getText(), equalTo(SUCCESSFUL_LOGIN_MESSAGE));
	}

	@Then("should return that the login was unsuccessful with an error {string}")
	public void should_return_that_the_login_was_unsuccessful_with_an_error_message(String message) {
		assertThat(loginPage.getAlertDanger().getText(), equalTo(message));
	}
	
	@After
	public void attachScreenshot(Scenario scenario) {
		byte[] screenshot = ((TakesScreenshot) loginPage.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.log("Current Page URL is " + loginPage.getDriver().getCurrentUrl());
		scenario.attach(screenshot, "image/png", scenario.getName());
	}

}
