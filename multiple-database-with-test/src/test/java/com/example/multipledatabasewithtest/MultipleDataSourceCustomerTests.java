package com.example.multipledatabasewithtest;

import com.example.multipledatabasewithtest.customer.data.CustomerModel;
import com.example.multipledatabasewithtest.customer.repo.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MultipleDataSourceCustomerTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional("customerTransactionManager")
    public void create_check_customer(){
        CustomerModel customerModel = new CustomerModel("user@javadevjournal.com","Robert","Hickle");
        customerModel = customerRepository.save(customerModel);

        Assert.assertNotNull(customerRepository.findById(customerModel.getId()));
        Assert.assertNotEquals(customerRepository.findById(customerModel.getId()).get().getEmail(),"user@javadevjournal.com");


    }
}
