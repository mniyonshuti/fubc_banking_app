package edu.mum.cs.cs425.fubcapplication.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountTypeId;
    @Column(nullable = false)
    private String accountTypeName;
    @OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL, mappedBy = "accountType")
    private List<Account> accountList;

    public AccountType() {
    }

    public AccountType(String accountTypeName) {
        this.accountTypeName = accountTypeName;
        this.accountList = new LinkedList<>();
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
