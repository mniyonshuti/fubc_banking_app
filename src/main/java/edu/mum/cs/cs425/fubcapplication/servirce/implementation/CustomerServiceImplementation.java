package edu.mum.cs.cs425.fubcapplication.servirce.implementation;

import edu.mum.cs.cs425.fubcapplication.model.Customer;
import edu.mum.cs.cs425.fubcapplication.repository.CustomerRepository;
import edu.mum.cs.cs425.fubcapplication.servirce.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public Customer saveNewCustomer(Customer s) {
        return customerRepository.save(s);
    }

    @Override
    public List<Customer> searchCustomer(String s) {
        return customerRepository.getAllByCustomerNumberContains(s);
    }

    @Override
    public Customer getCustomer(Long a) {
        return customerRepository.getAllByCustomerIDEquals(a);
    }
}
