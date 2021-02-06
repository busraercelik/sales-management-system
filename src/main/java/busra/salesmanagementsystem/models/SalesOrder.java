package busra.salesmanagementsystem.models;

import busra.salesmanagementsystem.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="SalesOrder")
public class SalesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "sales_order_id", referencedColumnName = "id")
    private List<OrderItem> orderItems;
    private Date orderDate;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(referencedColumnName = "cardNumber", name = "customer_card_number"),
            @JoinColumn(referencedColumnName = "phoneNo", name = "customer_phone_number")
    })
    private Customer customer;
    private OrderStatus orderStatus;
}
