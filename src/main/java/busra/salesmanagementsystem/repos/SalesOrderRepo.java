package busra.salesmanagementsystem.repos;

import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.models.SalesOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SalesOrderRepo extends CrudRepository<SalesOrder, Long> {
    List<SalesOrder> findByOrderDate(Date date);
    List<SalesOrder> findAll();
}
