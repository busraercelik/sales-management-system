package busra.salesmanagementsystem.dtos;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CreateOrderDTO {
    private String phoneNo;
    private Long cardNo;
    private List<String> itemName;
    private List<Integer> quantity;
}
//I will buy two eggs & three bananas
/*
{
    "itemName":[eggs, bananas],
    "quantity":[2, 3]
]

 */