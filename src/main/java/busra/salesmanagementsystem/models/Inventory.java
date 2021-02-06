package busra.salesmanagementsystem.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemName;
    private Integer price;
    private Integer totalRemaining;
}
