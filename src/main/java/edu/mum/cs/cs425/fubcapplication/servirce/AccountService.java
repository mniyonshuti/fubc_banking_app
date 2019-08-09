package edu.mum.cs.cs425.fubcapplication.servirce;

import edu.mum.cs.cs425.fubcapplication.model.Account;
import edu.mum.cs.cs425.fubcapplication.model.AccountType;

import java.util.List;
import java.util.Map;

public interface AccountService {
    public List<Account> listOfAllAccounts();
    public Account saveAccount(Account s);
    public Account searchAccount(String s);
    public Map<String, Double> summaryAccounts(List<Account> accounts, List<AccountType> accountTypes);
}
