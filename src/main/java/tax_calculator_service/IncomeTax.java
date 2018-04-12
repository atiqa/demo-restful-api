package tax_calculator_service;

import org.springframework.data.annotation.Id;

public class IncomeTax {

	@Id private String id;

	private String firstName;
	private String lastName;
	
	public IncomeTax() {}

    public IncomeTax(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
