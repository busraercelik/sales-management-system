package busra.salesmanagementsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerNamesDTO {
    private List<String> names;
}
