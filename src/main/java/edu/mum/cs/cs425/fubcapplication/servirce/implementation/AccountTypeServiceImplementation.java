package edu.mum.cs.cs425.fubcapplication.servirce.implementation;

import edu.mum.cs.cs425.fubcapplication.model.AccountType;
import edu.mum.cs.cs425.fubcapplication.repository.AccountTypeRepository;
import edu.mum.cs.cs425.fubcapplication.servirce.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImplementation implements AccountTypeService {
    @Autowired
    private AccountTypeRepository accountTypeRepository;
    @Override
    public AccountType saveAccountType(AccountType s) {
        return accountTypeRepository.save(s);
    }

    @Override
    public List<AccountType> getAccountTypes() {
        return accountTypeRepository.findAll(Sort.by("accountTypeName"));
    }

    @Override
    public AccountType getAccountType(Long a) {
        return accountTypeRepository.getAllByAccountTypeIdEquals(a);
    }
}
