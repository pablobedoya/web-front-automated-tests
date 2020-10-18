package automation.webfront.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Account {
	
	private Integer idGender;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private Integer birthDay;
	
	private Integer birthMonth;
	
	private Integer birthYear;
	
	private String addressFirstName;
	
	private String addressLastName;
	
	private String company;
	
	private String address;
	
	private String city;
	
	private Integer idState;
	
	private Long postalCode;
	
	private Integer idCountry;
	
	private String mobilePhone;
	
	private String alias;

}
