package com.example.Queryspringdatajpa.controller;

import com.example.Queryspringdatajpa.domain.Customer;
import com.example.Queryspringdatajpa.dto.CustomerCustomData;
import com.example.Queryspringdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //http://localhost:8080/1
    @GetMapping("/1")
    public List<Customer> getCustomer(){
        return customerRepository.getCustomer();
    }

    //http://localhost:8080/2
    @GetMapping("/2")
    public List<String> getCustomerFirstName(){
        return customerRepository.getCustomerFirstName();
    }

    //http://localhost:8080/3
    @GetMapping("/3")
    public List<String> getCustomerFirstNameWhereCountry(){
        return customerRepository.getCustomerFirstNameWhereCountry();
    }

    //http://localhost:8080/4?country=Poland
    @GetMapping("/4")
    public List<Customer> getCustomerWhereCountry(@RequestParam String country){
        return customerRepository.getCustomerWhereCountry(country);
    }

    //http://localhost:8080/5?country=Poland&lastName=Axe
    @GetMapping("/5")
    public List<Customer> getCustomerWhereCountryOrLastName(@RequestParam String country,@RequestParam String lastName){
        return customerRepository.getCustomerWhereCountryOrLastName(country, lastName);
    }

    //http://localhost:8080/6
    @GetMapping("/6")
    public List<CustomerCustomData> getCustomerIdAndCountry(){
        return customerRepository.getCustomerIdAndCountry();
    }

    //http://localhost:8080/7
    @GetMapping("/7")
    public List<Customer> getCustomerWhoOrdered(){
        return customerRepository.getCustomerWhoOrdered();
    }

    //http://localhost:8080/8
    @GetMapping("/8")
    public List<Customer> getCustomerWhoOrderedRejected(){
        return customerRepository.getCustomerWhoOrderedRejected();
    }

    //http://localhost:8080/last
    @GetMapping("/last")
    public List<Customer> getCustomerWhereCountryNative(){
        return customerRepository.getCustomerWhereCountryNative();
    }
}
