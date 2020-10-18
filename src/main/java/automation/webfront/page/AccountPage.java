package automation.webfront.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.webfront.config.ConfigProperties;
import automation.webfront.model.Account;

public class AccountPage extends BasePage {
	
	public AccountPage(WebDriver driver) {
		super(driver);
	}

	private static final String LOGOUT_PATH = "?mylogout";

	@FindBy(id = "id_gender1")
	private WebElement idGender1;

	@FindBy(id = "id_gender2")
	private WebElement idGender2;

	@FindBy(id = "customer_firstname")
	private WebElement customerFirstName;

	@FindBy(id = "customer_lastname")
	private WebElement customerLastName;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "days")
	private WebElement birthDay;

	@FindBy(id = "months")
	private WebElement birthMonth;

	@FindBy(id = "years")
	private WebElement birthYear;

	@FindBy(id = "firstname")
	private WebElement addressFirstName;

	@FindBy(id = "lastname")
	private WebElement addressLastName;

	@FindBy(id = "company")
	private WebElement company;

	@FindBy(id = "address1")
	private WebElement address;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "id_state")
	private WebElement idState;

	@FindBy(id = "postcode")
	private WebElement postalCode;

	@FindBy(id = "id_country")
	private WebElement idCountry;

	@FindBy(id = "phone_mobile")
	private WebElement mobilePhone;

	@FindBy(id = "alias")
	private WebElement alias;

	@FindBy(id = "submitAccount")
	private WebElement submitAccount;

	public void logout() {
		navigateTo(ConfigProperties.getInstance().getBaseUrl() + LOGOUT_PATH);
	}

	public void selectGender(int idGender) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(idGender1));
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(idGender2));
		
		if (idGender == 1)
			idGender1.click();

		if (idGender == 2)
			idGender2.click();
	}

	public void fillCustomerFirstName(String firstName) {
		this.customerFirstName.sendKeys(firstName);
	}

	public void fillCustomerLastName(String lastName) {
		this.customerLastName.sendKeys(lastName);
	}

	public void fillEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void fillPassword(String password) {
		this.password.sendKeys(password);
	}

	public void selectBirthDay(int day) {
		Select dropdown = new Select(birthDay);
		dropdown.selectByValue(String.valueOf(day));
	}

	public void selectBirthMonth(int month) {
		Select dropdown = new Select(birthMonth);
		dropdown.selectByValue(String.valueOf(month));
	}

	public void selectBirthYear(int year) {
		Select dropdown = new Select(birthYear);
		dropdown.selectByValue(String.valueOf(year));
	}

	public void fillAddressFirstName(String firstName) {
		this.addressFirstName.clear();
		this.addressFirstName.sendKeys(firstName);
	}

	public void fillAddressLastName(String lastName) {
		this.addressLastName.clear();
		this.addressLastName.sendKeys(lastName);
	}

	public void fillCompany(String company) {
		this.company.sendKeys(company);
	}

	public void fillAddress(String address) {
		this.address.sendKeys(address);
	}

	public void fillCity(String city) {
		this.city.sendKeys(city);
	}

	public void selectIdState(int id) {
		Select dropdown = new Select(idState);
		dropdown.selectByValue(String.valueOf(id));
	}

	public void fillPostalCode(long postalCode) {
		this.postalCode.sendKeys(String.valueOf(postalCode));
	}

	public void selectIdCountry(int id) {
		Select dropdown = new Select(idCountry);
		dropdown.selectByValue(String.valueOf(id));
	}

	public void fillMobilePhone(String mobilePhone) {
		this.mobilePhone.sendKeys(mobilePhone);
	}

	public void fillAlias(String alias) {
		this.alias.sendKeys(alias);
	}

	public void clickSubmitAccount() {
		submitAccount.click();
	}
	
	public void fillAllAccountData(Account account) {
		selectGender(account.getIdGender());
		fillCustomerFirstName(account.getFirstName());
		fillCustomerLastName(account.getLastName());
		fillEmail(account.getEmail());
		fillPassword(account.getPassword());
		selectBirthDay(account.getBirthDay());
		selectBirthMonth(account.getBirthMonth());
		selectBirthYear(account.getBirthYear());
		fillAddressFirstName(account.getAddressFirstName());
		fillAddressLastName(account.getAddressLastName());
		fillCompany(account.getCompany());
		fillAddress(account.getAddress());
		fillCity(account.getCity());
		selectIdState(account.getIdState());
		fillPostalCode(account.getPostalCode());
		selectIdCountry(account.getIdCountry());
		fillMobilePhone(account.getMobilePhone());
		fillAlias(account.getAlias());
	}

}
