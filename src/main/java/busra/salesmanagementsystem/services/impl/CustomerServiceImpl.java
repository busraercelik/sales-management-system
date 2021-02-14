package busra.salesmanagementsystem.services.impl;

import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.services.CustomerService;
import busra.salesmanagementsystem.dtos.CustomerDTO;
import busra.salesmanagementsystem.mappers.CustomerMapper;
import busra.salesmanagementsystem.models.pk.CustomerPK;
import busra.salesmanagementsystem.repos.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Customer getCustomerByCustomerCardAndPhoneNo(Long cardNumber, String phoneNo) {
        CustomerPK customerPK = new CustomerPK();
        customerPK.setPhoneNo(phoneNo);
        customerPK.setCardNumber(cardNumber);
        return customerRepo.findById(customerPK).get();
    }

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOtoCustomer(customerDTO);

        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepo.findAll();
    }
}
