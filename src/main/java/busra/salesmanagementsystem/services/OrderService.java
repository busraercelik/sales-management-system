package busra.salesmanagementsystem.services;

import busra.salesmanagementsystem.dtos.CreateOrderDTO;
import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.models.SalesOrder;

public interface OrderService {
    SalesOrder createOrder(CreateOrderDTO createOrderDTO) throws Exception;
}
