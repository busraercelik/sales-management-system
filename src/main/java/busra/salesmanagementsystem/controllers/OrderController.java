package busra.salesmanagementsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @PostMapping(path = "/create")
    public ResponseEntity<?> createOrder(){
        // 1. get the customer
        // 2. create order for this customer
        return new ResponseEntity<>("Cannot order now!", HttpStatus.FORBIDDEN);
    }

}
