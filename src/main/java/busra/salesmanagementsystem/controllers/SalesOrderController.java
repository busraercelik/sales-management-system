package busra.salesmanagementsystem.controllers;

import busra.salesmanagementsystem.dtos.CreateOrderDTO;
import busra.salesmanagementsystem.dtos.OrderAnalysisDTO;
import busra.salesmanagementsystem.enums.OrderStatus;
import busra.salesmanagementsystem.models.Receipt;
import busra.salesmanagementsystem.models.SalesOrder;
import busra.salesmanagementsystem.services.ReceiptService;
import busra.salesmanagementsystem.services.SalesOrderService;
import busra.salesmanagementsystem.utils.DateConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;



@RestController
@RequestMapping("order")
public class SalesOrderController {
    Logger logger = LoggerFactory.getLogger(SalesOrderController.class);

    @Autowired
    SalesOrderService salesOrderService;
    @Autowired
    ReceiptService receiptService;

    @RequestMapping (path = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderDTO createOrderDTO){
        try {
            return new ResponseEntity<>(salesOrderService.createOrder(createOrderDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get/order
    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<?> getAllDoneSales(){
        return new ResponseEntity<>(salesOrderService.getAllSalesOrder(), HttpStatus.OK);
    }

    @RequestMapping (path = "/complete/{orderId}", method = RequestMethod.PUT)
    public ResponseEntity<?> completeOrder(@PathVariable("orderId") Long orderId){

        // get all sales done
        SalesOrder salesOrder = salesOrderService.getOrderById(orderId);
        Receipt receipt = new Receipt();

        logger.info("Changing the order status of given order {}",salesOrder);
        if (salesOrder.getOrderStatus().equals(OrderStatus.PENDING)) {
            salesOrder.setOrderStatus(OrderStatus.COMPLETE);
            // calculate total price and set it to new receipt obj reference
            Integer totalPrice = 0;
            for (int i=0; i< salesOrder.getOrderItems().size(); i++) {
                logger.info("Calculating total price of item {}", salesOrder.getOrderItems().get(i).getItemName());
                Integer totalPriceOfItem = salesOrder.getOrderItems().get(i).getQuantity()*
                                     salesOrder.getOrderItems().get(i).getPrice();
                totalPrice += totalPriceOfItem;
            }
            receipt.setTotalPricePaid(Integer.toString(totalPrice));
            receipt.setReceiptDate(new Date());
            receipt.setSalesOrder(salesOrder);
            receiptService.upsert(receipt);
            salesOrderService.update(salesOrder);
        }


        return new ResponseEntity<>(salesOrder, HttpStatus.CREATED);
    }

    @RequestMapping (path = "/{date}", method = RequestMethod.GET)
    public ResponseEntity<?> checkTotalSalesOnADate(@PathVariable("date") String dateAsString){
        try {
            List<SalesOrder> salesOrders = salesOrderService.getAllSalesOnOrderDate(DateConversion.getDateFromString(dateAsString));
            return new ResponseEntity<>(new OrderAnalysisDTO(salesOrders.size()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No sales on "+dateAsString+ e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
