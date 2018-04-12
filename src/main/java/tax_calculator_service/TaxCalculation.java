package tax_calculator_service;

import java.time.LocalDateTime;

public class TaxCalculation {
	private String _id;
	private String customerId;
	private double superAmount;
	private double grossAmount;
	private double grossPlusSuperAmount;
	private double taxAmount;
	private double netAmount;
	private double netPlusSuperAmount;
	private String date;
	
	private TaxableIncomeRate taxableIncomeRate;
	
	public TaxableIncomeRate getTaxableIncomeRate() {
		return taxableIncomeRate;
	}

	public void setTaxableIncomeRate(TaxableIncomeRate taxableIncomeRate) {
		this.taxableIncomeRate = taxableIncomeRate;
	}

	TaxCalculation(String customerId){
		this.customerId = customerId;
		this.date = LocalDateTime.now().toString();
	};
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double getSuperAmount() {
		return superAmount;
	}
	public void setSuperAmount(double superAmount) {
		this.superAmount = superAmount;
	}
	public double getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}
	public double getGrossPlusSuperAmount() {
		return grossPlusSuperAmount;
	}
	public void setGrossPlusSuperAmount(double grossPlusSuperAmount) {
		this.grossPlusSuperAmount = grossPlusSuperAmount;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}
	public double getNetPlusSuperAmount() {
		return netPlusSuperAmount;
	}
	public void setNetPlusSuperAmount(double netPlusSuperAmount) {
		this.netPlusSuperAmount = netPlusSuperAmount;
	}
	
	

}
