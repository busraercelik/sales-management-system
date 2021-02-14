package busra.salesmanagementsystem.services;

import busra.salesmanagementsystem.dtos.CreateOrderDTO;
import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.models.SalesOrder;

import java.util.Date;
import java.util.List;

public interface SalesOrderService {
    SalesOrder createOrder(CreateOrderDTO createOrderDTO) throws Exception;
    List<SalesOrder> getAllSalesOnOrderDate(Date date);
    List<SalesOrder> getAllSalesOrder();
    SalesOrder update(SalesOrder so);
    SalesOrder getOrderById(Long id);
}
