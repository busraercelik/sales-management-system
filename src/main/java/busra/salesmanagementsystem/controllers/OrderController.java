package busra.salesmanagementsystem.controllers;

import busra.salesmanagementsystem.dtos.CreateOrderDTO;
import busra.salesmanagementsystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping (path = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderDTO createOrderDTO){
        try {
            return new ResponseEntity<>(orderService.createOrder(createOrderDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
