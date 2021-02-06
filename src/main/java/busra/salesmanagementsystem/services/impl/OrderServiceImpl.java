package busra.salesmanagementsystem.services.impl;

import busra.salesmanagementsystem.dtos.CreateOrderDTO;
import busra.salesmanagementsystem.enums.OrderStatus;
import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.models.Inventory;
import busra.salesmanagementsystem.models.OrderItem;
import busra.salesmanagementsystem.models.SalesOrder;
import busra.salesmanagementsystem.repos.OrderRepo;
import busra.salesmanagementsystem.services.CustomerService;
import busra.salesmanagementsystem.services.InventoryService;
import busra.salesmanagementsystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    CustomerService customerService;
    @Autowired
    InventoryService inventoryService;

    @Override
    public SalesOrder createOrder(CreateOrderDTO createOrderDTO) throws Exception {
        // get customer's phone no and card no from request body and return the customer obj
        Customer customer = customerService
                .getCustomerByCustomerCardAndPhoneNo(createOrderDTO.getCardNo(), createOrderDTO.getPhoneNo());


        List<OrderItem> items= new ArrayList<>();
        for(int i=0; i<createOrderDTO.getQuantity().size(); i++){

            String itemName = createOrderDTO.getItemName().get(i);
            Integer quantityOfItem = createOrderDTO.getQuantity().get(i);
            Inventory inventory = inventoryService.getInventoryByName(itemName);
            Integer remainingQuantity = inventory.getTotalRemaining();

            if (inventory == null ){
                throw new Exception("Item is not in inventory!");
            }
            if (remainingQuantity < quantityOfItem){
                throw new Exception("not enough item left in inventory!");
            }

            OrderItem oi = new OrderItem();

            oi.setItemName(itemName);
            oi.setQuantity(quantityOfItem);


            oi.setPrice(inventory.getPrice()*quantityOfItem);
            remainingQuantity = remainingQuantity - quantityOfItem;
            inventory.setTotalRemaining(remainingQuantity);
            inventoryService.upsert(inventory);
            items.add(oi);
        }

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setOrderItems(items);
        salesOrder.setCustomer(customer);
        salesOrder.setOrderDate(new Date());
        salesOrder.setOrderStatus(OrderStatus.PENDING);
        return orderRepo.save(salesOrder);
    }
}
