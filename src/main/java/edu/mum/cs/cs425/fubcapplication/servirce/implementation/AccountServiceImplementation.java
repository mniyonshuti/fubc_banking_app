package edu.mum.cs.cs425.fubcapplication.servirce.implementation;

import edu.mum.cs.cs425.fubcapplication.model.Account;
import edu.mum.cs.cs425.fubcapplication.model.AccountType;
import edu.mum.cs.cs425.fubcapplication.repository.AccountRepository;
import edu.mum.cs.cs425.fubcapplication.servirce.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImplementation implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> listOfAllAccounts() {
        return accountRepository.findAll(Sort.by("accountNumber"));
    }

    @Override
    public Account saveAccount(Account s) {
        return accountRepository.save(s);
    }

    @Override
    public Account searchAccount(String s) {
        return null;
    }

    @Override
    public Map<String, Double> summaryAccounts(List<Account> accounts, List<AccountType> accountTypes) {
        Map<String, Double> summary = new LinkedHashMap<>();
        double totalNetworth = 0;
        for(AccountType s : accountTypes){
            double sum = 0;
            for(Account account : accounts){
                if(account.getAccountType().getAccountTypeId() == s.getAccountTypeId()){
                    sum += account.getBalance();
                }
            }
            totalNetworth += sum;
            summary.put(s.getAccountTypeName(), sum);
        }
        summary.put("BANK LIQUDITY POSITION", totalNetworth);
        return summary;
    }


}
