package tax_calculator_service;


import javax.json.JsonArray;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/taxapi")
public class TaxCalculationController {

	@Autowired
	private IncomeTaxRepository repository;

	@Autowired
	private CustomerRepository custommerRepository;

	@Autowired
	private TaxCalculationService taxCalculationService;

	@RequestMapping(value = "/gross/{grossAmount}", method = RequestMethod.GET)
	public ResponseEntity<?> calculateTaxOption1(@PathVariable("grossAmount") double grossAmount) {
		System.out.println("gross=" + grossAmount);
		JsonObject taxCalculation = taxCalculationService.calculate(grossAmount, 0, 0);
		System.out.println("taxCalculation=" + taxCalculation);
		return new ResponseEntity<String>(taxCalculation.toString(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/gross/{grossAmount}/super/{superAmount}", method = RequestMethod.GET)
	public ResponseEntity<?> calculateTaxOption2(@PathVariable("grossAmount") double grossAmount, @PathVariable("superAmount") double superAmount) {
		System.out.println("gross=" + grossAmount);
		JsonObject taxCalculation = taxCalculationService.calculate(grossAmount, superAmount, 0);
		System.out.println("taxCalculation=" + taxCalculation);
		return new ResponseEntity<String>(taxCalculation.toString(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/gross/{grossAmount}/superRate/{superRate}", method = RequestMethod.GET)
	public ResponseEntity<?> calculateTaxOption3(@PathVariable("grossAmount") double grossAmount, @PathVariable("superRate") double superRate) {
		System.out.println("gross=" + grossAmount);
		JsonObject taxCalculation = taxCalculationService.calculate(grossAmount, 0, superRate);
		System.out.println("taxCalculation=" + taxCalculation);
		return new ResponseEntity<String>(taxCalculation.toString(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ResponseEntity<?> retrieveTaxCalculationRecords() {
		JsonArray records = taxCalculationService.retrieveTaxCalculationRecords();
		System.out.println("list=" + records);
		return new ResponseEntity<String>(records.toString(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/deleteHistory", method = RequestMethod.DELETE)
	ResponseEntity<?> deleteHistory() {
		repository.deleteAll();
		return new ResponseEntity<String>("History deleted", HttpStatus.OK);
	}
	
}
