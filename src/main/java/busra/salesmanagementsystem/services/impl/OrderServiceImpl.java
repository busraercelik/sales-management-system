package busra.salesmanagementsystem.services.impl;

import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.models.SalesOrder;
import busra.salesmanagementsystem.repos.CustomerRepo;
import busra.salesmanagementsystem.repos.OrderRepo;
import busra.salesmanagementsystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;
    CustomerRepo customerRepo;

    @Override
    public SalesOrder createRecipeForGivenCustomer(Customer customer) {
        return null;
    }
}
