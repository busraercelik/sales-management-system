package busra.salesmanagementsystem.services;

import busra.salesmanagementsystem.models.Inventory;

public interface InventoryService {
    Inventory getInventoryByName(String name);
    Inventory upsert(Inventory inventory);//update & save
}
