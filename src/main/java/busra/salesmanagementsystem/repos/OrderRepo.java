package busra.salesmanagementsystem.repos;


import busra.salesmanagementsystem.models.SalesOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<SalesOrder, Long> {

}
