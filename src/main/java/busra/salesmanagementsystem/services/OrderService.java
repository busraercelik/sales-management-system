package busra.salesmanagementsystem.services;

import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.models.SalesOrder;

public interface OrderService {
    SalesOrder createRecipeForGivenCustomer(Customer customer);
}
