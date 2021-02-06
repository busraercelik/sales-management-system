package busra.salesmanagementsystem.services.impl;

import busra.salesmanagementsystem.models.Inventory;
import busra.salesmanagementsystem.repos.InventoryRepo;
import busra.salesmanagementsystem.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepo inventoryRepo;

    @Override
    public Inventory getInventoryByName(String name) {
        return inventoryRepo.findByItemName(name);
    }

    @Override
    public Inventory upsert(Inventory inventory) {
        return inventoryRepo.save(inventory);
    }
}
