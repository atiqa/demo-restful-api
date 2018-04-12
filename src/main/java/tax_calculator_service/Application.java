
package tax_calculator_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableWebSecurity
public class Application implements CommandLineRunner {
	
	@Autowired
	private IncomeTaxRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
/*********************8
		
		repository.deleteAll();

		// save a couple of customers
		repository.save(new IncomeTax("Alice", "Smith"));
		repository.save(new IncomeTax("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (IncomeTax customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (IncomeTax customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
*****************/
		for (TaxCalculation taxInfo : repository.findByCustomerId("user")) {
			System.out.println("GrossAmount=" + taxInfo.getGrossAmount());
		}
	}
	
	 @Bean
	    WebMvcConfigurer configurer () {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addResourceHandlers (ResourceHandlerRegistry registry) {
	                registry.addResourceHandler("/**").
	                          addResourceLocations("classpath:/templates/");
	            }
	        };
	    }
}
