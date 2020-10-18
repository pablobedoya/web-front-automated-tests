package automation.webfront.data;

import java.util.Calendar;
import java.util.Date;

import com.github.javafaker.Faker;

import automation.webfront.model.Account;
import automation.webfront.model.EmailType;
import automation.webfront.model.PasswordType;

public final class AccountDataUtil {

	private static Faker faker = new Faker();

	private AccountDataUtil() {
	}

	public static Account generateAccount() {
		String firstName = generateFirstName();
		String lastName = generateLastName();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(generateBirthday());
		Integer birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		Integer birthMonth = calendar.get(Calendar.MONTH);
		Integer birthYear = calendar.get(Calendar.YEAR);
		
		return Account.builder()
				.idGender(generateIdGender())
				.firstName(firstName)
				.lastName(lastName)
				.email(generateEmail())
				.password(generatePassword())
				.birthDay(birthDay)
				.birthMonth(birthMonth)
				.birthYear(birthYear)
				.addressFirstName(firstName)
				.addressLastName(lastName)
				.company(generateCompany())
				.address(generateAddress())
				.city(generateCity())
				.idState(generateIdState())
				.postalCode(generatePostalCode())
				.idCountry(generateIdCountry())
				.mobilePhone(generateMobilePhone())
				.alias(generateAlias())
				.build();
	}

	public static int generateIdGender() {
		return faker.number().numberBetween(1, 2);
	}

	public static String generateFirstName() {
		return faker.name().firstName();
	}

	public static String generateLastName() {
		return faker.name().lastName();
	}

	public static String generateEmail() {
		return faker.internet().emailAddress();
	}

	public static String generatePassword() {
		return faker.internet().password();
	}

	public static Date generateBirthday() {
		return faker.date().birthday();
	}

	public static String generateCompany() {
		return faker.company().name();
	}

	public static String generateAddress() {
		return faker.address().fullAddress();
	}

	public static String generateCity() {
		return faker.address().city();
	}

	public static int generateIdState() {
		return faker.number().numberBetween(1, 50);
	}

	public static long generatePostalCode() {
		return faker.number().randomNumber(5, true);
	}

	public static int generateIdCountry() {
		return 21; // Only country available on the website
	}

	public static String generateMobilePhone() {
		return faker.phoneNumber().cellPhone();
	}

	public static String generateAlias() {
		return faker.name().username();
	}
	
	public static String generateEmailByType(EmailType emailType) {
		switch (emailType) {
			case VALID:
				return generateEmail();
			case INVALID:
				return generateAlias();
			case BLANK:
				return "";
			default:
				throw new RuntimeException("The email type does not exist");
		}
	}

	public static String generatePasswordByType(PasswordType passwordType) {
		switch (passwordType) {
			case VALID:
				return generatePassword();
			case INVALID:
				return faker.number().digit();
			case BLANK:
				return "";
			default:
				throw new RuntimeException("The password type does not exist");
		}
	}

}
