package busra.salesmanagementsystem.controllers;

import busra.salesmanagementsystem.models.OrderItem;
import busra.salesmanagementsystem.models.Receipt;
import busra.salesmanagementsystem.models.SalesOrder;
import busra.salesmanagementsystem.services.ReceiptService;
import busra.salesmanagementsystem.services.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("receipt")
public class ReceiptController {

    @Autowired
    ReceiptService receiptService;
    @Autowired
    SalesOrderService salesOrderService;

    @RequestMapping (path = "/{orderid}", method = RequestMethod.GET)
    public ResponseEntity<?> showReceipt(@PathVariable ("orderid") Long orderid){
        SalesOrder salesOrder = salesOrderService.getOrderById(orderid);
        return new ResponseEntity<>(receiptService.getReceiptForOrder(salesOrder), HttpStatus.OK);
    }
}
