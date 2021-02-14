package busra.salesmanagementsystem.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private SalesOrder salesOrder;
    @Temporal(TemporalType.DATE)
    private Date receiptDate;
    private String totalPricePaid;
}
