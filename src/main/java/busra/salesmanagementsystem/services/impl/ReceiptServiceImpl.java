package busra.salesmanagementsystem.services.impl;

import busra.salesmanagementsystem.models.Receipt;
import busra.salesmanagementsystem.models.SalesOrder;
import busra.salesmanagementsystem.repos.ReceiptRepo;
import busra.salesmanagementsystem.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    ReceiptRepo receiptRepo;

    @Override
    public Receipt getReceipt(Long id) {
        try {
            if (receiptRepo.findById(id).isPresent()) {
                return receiptRepo.findById(id).get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Receipt getReceiptForOrder(SalesOrder salesOrder) {
        return receiptRepo.findBySalesOrder(salesOrder);
    }

    @Override
    public Receipt upsert(Receipt receipt) {
        return receiptRepo.save(receipt);
    }
}
