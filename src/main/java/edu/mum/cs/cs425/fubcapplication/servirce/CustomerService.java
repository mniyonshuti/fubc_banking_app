package edu.mum.cs.cs425.fubcapplication.servirce;

import edu.mum.cs.cs425.fubcapplication.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public Customer saveNewCustomer(Customer s);
    public List<Customer> searchCustomer(String s);
    public Customer getCustomer(Long a);
}
