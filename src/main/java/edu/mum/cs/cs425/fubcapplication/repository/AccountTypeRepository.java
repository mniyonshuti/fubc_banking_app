package edu.mum.cs.cs425.fubcapplication.repository;

import edu.mum.cs.cs425.fubcapplication.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
    public AccountType getAllByAccountTypeIdEquals(Long s);
}
