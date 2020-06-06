package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

    public static final String FIRSTNAME = "Joe";
    public static final String LASTNAME = "Jo";
    public static final long ID = 1L;
    public static final String CUSTOMER_URL = "/api/v1/customers/joe_jo";

    CustomerMapper customerMapper;

    @Before
    public void setUp() throws Exception {
        customerMapper = CustomerMapper.INSTANCE;
    }

    @Test
    public void customerToCustomerDTO() {
        Customer c = new Customer();
        c.setId(ID);
        c.setFirstName(FIRSTNAME);
        c.setLastName(LASTNAME);
        c.setCustomer_url(CUSTOMER_URL);

        CustomerDTO cDTO = customerMapper.customerToCustomerDTO(c);

        assertEquals(Long.valueOf(ID), cDTO.getId());
        assertEquals(FIRSTNAME, cDTO.getFirstName());
        assertEquals(LASTNAME, cDTO.getLastName());
        assertEquals(CUSTOMER_URL, cDTO.getCustomer_url());
    }
}
