package tax_calculator_service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaxCalculationService {
	
	@Autowired
	private CustomerRepository custommerRepository;
	
	@Autowired
	private IncomeTaxRepository repository;
	
	public JsonObject calculate (double income, double superAmount, double superRate)  {
		RestTemplate restTemplate = new RestTemplate();
		String url  = "http://localhost:8080/taxrate";
		// ResponseEntity<List> response  = restTemplate.getForEntity(fooResourceUrl, List.class);
		// List<TaxableIncomeRate> taxableIncomeRateList = response.;
		double superannuationRate = superRate == 0 ? 0.095 : superRate;
		double superannuation = superAmount == 0 ? superannuationRate * income : superAmount;
		superannuation = DoubleRounder.round(superannuation, 2);
		double gross = income - superannuation;
		gross = DoubleRounder.round(gross, 2);
		TaxableIncomeRateList taxableIncomeRateList = restTemplate.getForObject(url, TaxableIncomeRateList.class, 200);
		System.out.println("taxableIncomeRateList=" + taxableIncomeRateList);
		for(TaxableIncomeRate rate : taxableIncomeRateList.getList()) {
			if(income >= rate.getMinimumIncome() && income <= rate.getMaximumIncome()) {
				double tax = DoubleRounder.round(rate.getTaxRate() * (gross - rate.getMinimumIncome()) + rate.getMinimumTax(), 2);
				double net = DoubleRounder.round(gross - tax, 2);
				JsonObject jsonObject = Json.createObjectBuilder().add("gross", gross).add("super", superannuation).add("tax", tax).add("net", net).add("net+super", net + superannuation).build();
				TaxCalculation taxCalculation = new TaxCalculation("user");
				taxCalculation.setGrossAmount(gross);
				taxCalculation.setGrossPlusSuperAmount(gross + superannuation);
				taxCalculation.setNetAmount(net);				
				taxCalculation.setNetPlusSuperAmount(net + superannuation);
				taxCalculation.setSuperAmount(superannuation);
				taxCalculation.setTaxAmount(tax);
				taxCalculation.setTaxableIncomeRate(rate);
				repository.save(taxCalculation);
				return jsonObject;
				
			}
			System.out.println("rate=" + rate.getTaxRate());
		}
		
		return null;
	}
	
	public JsonArray retrieveTaxCalculationRecords() {
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for (TaxCalculation taxRecord : repository.findByCustomerId("user")) {
			TaxableIncomeRate taxableIncomeRate = taxRecord.getTaxableIncomeRate();
			JsonObject taxRateObject = Json.createObjectBuilder()
					.add("minimumIncome", taxableIncomeRate.getMinimumIncome())
					.add("maximumIncome", taxableIncomeRate.getMaximumIncome())
					.add("minimumTax", taxableIncomeRate.getMinimumTax())
					.add("taxRate", taxableIncomeRate.getTaxRate())
					.build();
			JsonObject jsonObject = Json.createObjectBuilder()
					.add("id", taxRecord.get_id())
					.add("date", taxRecord.getDate())
					.add("gross", taxRecord.getGrossAmount())
					.add("super", taxRecord.getSuperAmount())
					.add("tax", taxRecord.getTaxAmount())
					.add("net", taxRecord.getNetAmount())
					.add("net+super", taxRecord.getNetPlusSuperAmount())
					.add("taxRate", taxRateObject)
					.build();
			builder.add(jsonObject);

			System.out.println("Record=" + jsonObject.toString());
		}
		return builder.build();
	}

}
