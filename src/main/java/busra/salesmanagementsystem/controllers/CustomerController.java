package busra.salesmanagementsystem.controllers;

import busra.salesmanagementsystem.dtos.CustomerDTO;
import busra.salesmanagementsystem.dtos.CustomerNamesDTO;
import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.models.SalesOrder;
import busra.salesmanagementsystem.services.CustomerService;
import busra.salesmanagementsystem.services.SalesOrderService;
import busra.salesmanagementsystem.utils.DateConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    SalesOrderService salesOrderService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomer(){
        List<String> custNames = customerService
                            .getAllCustomers().stream().map(customer -> customer.getName()).collect(Collectors.toList());
        return new ResponseEntity<>(new CustomerNamesDTO(custNames), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.createCustomer(customerDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{date}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomersShoppedOnADate(@PathVariable("date") String dateAsString) throws ParseException {
        List<SalesOrder> salesOrders = salesOrderService.getAllSalesOnOrderDate(DateConversion.getDateFromString(dateAsString));

        Map<String,Integer> customers= new LinkedHashMap<>();
        for (int i=0; i<salesOrders.size(); i++) {
            String customerName = salesOrders.get(i).getCustomer().getName();
            if (!customers.containsKey(customerName)){
                customers.put(customerName, i);
            }
        }

        List<String> customerList = new ArrayList<>();
        for (String s : customers.keySet()) {
            customerList.add(s);
        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

}
