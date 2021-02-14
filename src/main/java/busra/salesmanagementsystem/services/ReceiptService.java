package busra.salesmanagementsystem.services;

import busra.salesmanagementsystem.models.Receipt;
import busra.salesmanagementsystem.models.SalesOrder;

import javax.persistence.criteria.Order;
import java.util.List;

public interface ReceiptService {
    Receipt getReceipt(Long id);
    Receipt getReceiptForOrder(SalesOrder salesOrder);
    Receipt upsert(Receipt receipt);
}
