package tax_calculator_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@Controller
@RequestMapping("/")
public class CustomerPageController {

	@Autowired
	private IncomeTaxRepository repository;
	
	@Autowired
	private CustomerRepository custommerRepository;
    
    @RequestMapping( method = RequestMethod.GET)
    public String homepage() {
    	return "home";
	}
}
