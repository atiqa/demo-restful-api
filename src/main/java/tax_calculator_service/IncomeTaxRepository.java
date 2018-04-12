
package tax_calculator_service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tax", path = "tax")
public interface IncomeTaxRepository extends MongoRepository<TaxCalculation, String> {

	List<TaxCalculation> findByCustomerId(@Param("customerId") String customerId);
}
