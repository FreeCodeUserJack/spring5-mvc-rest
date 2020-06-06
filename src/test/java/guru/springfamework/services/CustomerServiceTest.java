package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    public static final String FIRSTNAME = "Joe";
    public static final String LASTNAME = "Jo";
    public static final long ID = 1L;
    public static final String CUSTOMER_URL = "/api/v1/customers/joe_jo";

    @Mock
    CustomerRepository customerRepository;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getAllCustomers() {
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        assertEquals(3, customerDTOS.size());
    }

    @Test
    public void getCustomerByFirstName() {
        Customer c = new Customer();
        c.setId(ID);
        c.setFirstName(FIRSTNAME);
        c.setLastName(LASTNAME);
        c.setCustomer_url(CUSTOMER_URL);

        when(customerRepository.findByFirstName(anyString())).thenReturn(c);

        CustomerDTO cDTO = customerService.getCustomerByFirstName(FIRSTNAME);

        assertEquals(Long.valueOf(ID), cDTO.getId());
        assertEquals(FIRSTNAME, cDTO.getFirstName());
        assertEquals(LASTNAME, cDTO.getLastName());
        assertEquals(CUSTOMER_URL, cDTO.getCustomer_url());
    }
}
