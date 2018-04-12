package tax_calculator_service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/taxrate")
public class TaxableIncomeRateController {
	static List<TaxableIncomeRate> taxableIncomeRateList = new ArrayList<>();
	static {
		taxableIncomeRateList.add(new TaxableIncomeRate(1, 0, 18200, 0, 0));
		taxableIncomeRateList.add(new TaxableIncomeRate(2, 18201, 37000, 0, 0.19));
		taxableIncomeRateList.add(new TaxableIncomeRate(3, 37001, 87000, 3572, 0.325));
		taxableIncomeRateList.add(new TaxableIncomeRate(4, 87001, 180000, 19822, 0.37));
		taxableIncomeRateList.add(new TaxableIncomeRate(5, 180001, 999999999, 54232, 0.45));
	}

	@Autowired
	private IncomeTaxRepository repository;
	
	@Autowired
	private CustomerRepository custommerRepository;
    
    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<TaxableIncomeRateList> retrieveRates() {
	        return new ResponseEntity<TaxableIncomeRateList>(new TaxableIncomeRateList(taxableIncomeRateList), HttpStatus.OK);
	}
}
