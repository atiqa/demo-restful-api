package tax_calculator_service;

import java.util.List;

public class TaxableIncomeRateList {
	private List<TaxableIncomeRate> list;
	TaxableIncomeRateList(){};
	
	TaxableIncomeRateList(List<TaxableIncomeRate> list) {
		this.list = list;
	}

	public List<TaxableIncomeRate> getList() {
		return list;
	}

	public void setList(List<TaxableIncomeRate> list) {
		this.list = list;
	}
}
