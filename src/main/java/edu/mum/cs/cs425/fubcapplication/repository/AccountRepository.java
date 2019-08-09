package edu.mum.cs.cs425.fubcapplication.repository;

import edu.mum.cs.cs425.fubcapplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    public Iterable<Account> getAllByAccountNumberContains(String s);
}
