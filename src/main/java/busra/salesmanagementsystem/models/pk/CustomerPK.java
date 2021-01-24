package busra.salesmanagementsystem.models.pk;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class CustomerPK implements Serializable {
    private Long cardNumber;
    private String phoneNo;
}
