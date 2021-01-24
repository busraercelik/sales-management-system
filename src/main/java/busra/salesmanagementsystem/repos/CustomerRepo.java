package busra.salesmanagementsystem.repos;

import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.models.pk.CustomerPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, CustomerPK> {

}
