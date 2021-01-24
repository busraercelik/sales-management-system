package busra.salesmanagementsystem.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemName;
    private String quantity;
    private String price;
}
