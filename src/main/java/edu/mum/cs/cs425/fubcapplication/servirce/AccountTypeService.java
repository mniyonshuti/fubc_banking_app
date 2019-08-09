package edu.mum.cs.cs425.fubcapplication.servirce;

import edu.mum.cs.cs425.fubcapplication.model.AccountType;

import java.util.List;

public interface AccountTypeService {
    public AccountType saveAccountType(AccountType s);
    public List<AccountType> getAccountTypes();
    public AccountType getAccountType(Long a);
}
