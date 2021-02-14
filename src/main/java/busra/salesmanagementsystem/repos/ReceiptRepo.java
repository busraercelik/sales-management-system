package busra.salesmanagementsystem.repos;

import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.models.Receipt;
import busra.salesmanagementsystem.models.SalesOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepo extends CrudRepository<Receipt, Long> {
    Receipt findBySalesOrder(SalesOrder salesOrder);
}
