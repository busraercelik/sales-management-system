package busra.salesmanagementsystem.controllers;

import busra.salesmanagementsystem.dtos.CustomerDTO;
import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    CustomerService custService;

    @RequestMapping (path = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody CustomerDTO customerDTO){
        // 1. get the customer
        // 2. create order for this customer
        Customer customer = custService
                            .getCustomerByCustomerCardAndPhoneNo(customerDTO.getCardNo(), customerDTO.getPhoneNo());

        return new ResponseEntity<>("Cannot order now!", HttpStatus.FORBIDDEN);
    }

}
