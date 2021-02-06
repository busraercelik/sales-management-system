package busra.salesmanagementsystem.repos;

import busra.salesmanagementsystem.models.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepo extends CrudRepository<Inventory, Long> {
    Inventory findByItemName(String itemName);
}
