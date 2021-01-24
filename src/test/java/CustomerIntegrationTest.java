import busra.salesmanagementsystem.AppRunner;
import busra.salesmanagementsystem.dtos.CustomerDTO;
import busra.salesmanagementsystem.mappers.CustomerMapper;
import busra.salesmanagementsystem.models.Customer;
import busra.salesmanagementsystem.services.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = {AppRunner.class})
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class CustomerIntegrationTest {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerMapper customerMapper;

    @Test
    public void testCreatingCustomer(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCardNo(4500_6700_3400_1200L);
        customerDTO.setName("Celik");
        customerDTO.setPhoneNo("+91-9923546349");
        customerService.createCustomer(customerDTO);
        Customer customerFromDb= customerService
                .getCustomerByCustomerCardAndPhoneNo(customerDTO.getCardNo(), customerDTO.getPhoneNo());
        Assert.assertNotNull(customerFromDb);
      /*  Assert.assertTrue(customerFromDb.getId().getCardNumber().equals(customerDTO.getCardNo()) &&
                customerFromDb.getId().getPhoneNo().equals(customerDTO.getPhoneNo()));
      */
    }

    @Test
    public void testCustomerMapper(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCardNo(4500_6700_3400_1200L);
        customerDTO.setName("Celik");
        customerDTO.setPhoneNo("+91-9923546349");
        Customer customer = customerMapper.customerDTOtoCustomer(customerDTO);
        System.out.println("Customer credentials: \n" + customer);
    }

}
