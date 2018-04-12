package tax_calculator_service;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id private String id;

	private String firstName;
	private String lastName;
	private String email;
	
	public Customer() {}

    public Customer(String email) {
        this.email = email;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.lastName = email;
	}
}
