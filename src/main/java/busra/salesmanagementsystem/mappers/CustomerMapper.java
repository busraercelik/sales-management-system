package busra.salesmanagementsystem.mappers;

import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.dtos.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// spring finds impl with the componentModel attribute
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    // specify the names (because names are not matching)
    @Mappings({
            @Mapping(target = "id.cardNumber",source="cardNo"),
            @Mapping(target = "id.phoneNo",source="phoneNo")
    })
    Customer customerDTOtoCustomer(CustomerDTO customerDTO);
}
