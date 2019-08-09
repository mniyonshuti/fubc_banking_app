package edu.mum.cs.cs425.fubcapplication.repository;

import edu.mum.cs.cs425.fubcapplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> getAllByCustomerNumberContains(String s);
    public Customer getAllByCustomerIDEquals(Long n);
}
