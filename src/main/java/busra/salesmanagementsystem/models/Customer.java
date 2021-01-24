package busra.salesmanagementsystem.models;

import busra.salesmanagementsystem.models.pk.CustomerPK;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class Customer {
    @EmbeddedId
    private CustomerPK id;
    private String name;
}
