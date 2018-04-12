

public class TaxableIncomeRate {
	private int bracket;
	private int minimumIncome;
	private int maximumIncome;
	private double taxRate;
	
	TaxableIncomeRate(int bracket, int minimumIncome, int maximumIncome, double taxRate) {
		this.bracket = bracket;
		this.minimumIncome = minimumIncome;
		this.maximumIncome = maximumIncome;
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
	public int getMinimumIncome() {
		return minimumIncome;
	}
	public void setMinimumIncome(int minimumIncome) {
		this.minimumIncome = minimumIncome;
	}
	public int getMaximumIncome() {
		return maximumIncome;
	}
	public void setMaximumIncome(int maximumIncome) {
		this.maximumIncome = maximumIncome;
	}
}
