package edu.mum.cs.cs425.fubcapplication.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(nullable = false)
    private Long accountNumber;
    @Column(nullable = false)
    private Double balance;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_type_id_fk")
    private AccountType accountType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id_fk")
    private Customer customer;

    @Transient Long accountTypeIdTransient;
    @Transient Long customerIdTransient;
    public Account() {
    }

    public Account(Long accountNumber, Double balance, AccountType accountType, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.customer = customer;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getAccountTypeIdTransient() {
        return accountTypeIdTransient;
    }

    public void setAccountTypeIdTransient(Long accountTypeIdTransient) {
        this.accountTypeIdTransient = accountTypeIdTransient;
    }

    public Long getCustomerIdTransient() {
        return customerIdTransient;
    }

    public void setCustomerIdTransient(Long customerIdTransient) {
        this.customerIdTransient = customerIdTransient;
    }

//    @Override
//    public String toString() {
//        return "Account{" +
//                "accountId=" + accountId +
//                ", accountNumber=" + accountNumber +
//                ", balance=" + balance +
//                ", accountType=" + accountType +
//                ", customer=" + customer +
//                '}';
//    }
}
