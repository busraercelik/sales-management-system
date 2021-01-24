package busra.salesmanagementsystem.services;

import busra.salesmanagementsystem.dtos.CustomerDTO;
import busra.salesmanagementsystem.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerByCustomerCardAndPhoneNo(Long cardNumber, String phoneNo);
    Customer createCustomer(CustomerDTO customerDTO);
    List<Customer> getAllCustomers();
}
