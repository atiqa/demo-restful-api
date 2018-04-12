package tax_calculator_service;

public class TaxableIncomeRate {
	private int bracket;
	private double minimumIncome;
	private double maximumIncome;
	private double minimumTax;
	public double getMinimumTax() {
		return minimumTax;
	}

	public void setMinimumTax(double minimumTax) {
		this.minimumTax = minimumTax;
	}
	private double taxRate;
	
	TaxableIncomeRate(){};
	
	TaxableIncomeRate(int bracket, double minimumIncome, double maximumIncome, double minimumTax, double taxRate) {
		this.bracket = bracket;
		this.minimumIncome = minimumIncome;
		this.maximumIncome = maximumIncome;
		this.minimumTax = minimumTax;
		this.taxRate = taxRate;
	}
	
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	public int getBracket() {
		return bracket;
	}
	public void setBracket(int bracket) {
		this.bracket = bracket;
	}
	public double getMinimumIncome() {
		return minimumIncome;
	}
	public void setMinimumIncome(double minimumIncome) {
		this.minimumIncome = minimumIncome;
	}
	public double getMaximumIncome() {
		return maximumIncome;
	}
	public void setMaximumIncome(double maximumIncome) {
		this.maximumIncome = maximumIncome;
	}
}
