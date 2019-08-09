package edu.mum.cs.cs425.fubcapplication.controller;

import edu.mum.cs.cs425.fubcapplication.model.Account;
import edu.mum.cs.cs425.fubcapplication.model.AccountType;
import edu.mum.cs.cs425.fubcapplication.model.Customer;
import edu.mum.cs.cs425.fubcapplication.servirce.AccountService;
import edu.mum.cs.cs425.fubcapplication.servirce.AccountTypeService;
import edu.mum.cs.cs425.fubcapplication.servirce.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping(value = {"/fubc/account/list"})
    public ModelAndView displayAllAccounts(){
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accounts = accountService.listOfAllAccounts();
        List<AccountType> accountTypes = accountTypeService.getAccountTypes();
        modelAndView.addObject("accounts", accountService.listOfAllAccounts());
        modelAndView.addObject("summary", accountService.summaryAccounts(accounts, accountTypes));
        modelAndView.setViewName("account/list");
        return modelAndView;
    }

    @GetMapping(value = {"/fubc/customer/search"})
    public String searchCustomer(@RequestParam("searchCustomer") String search){

      List<Customer> customers = customerService.searchCustomer(search);
      if(customers.isEmpty()){
          return "account/notfound";
      }
       return "redirect:/fubc/account/new";
    }

    @GetMapping(value = {"/fubc/account/new"})
        public String displayNewAccountPage(Model model ){
        model.addAttribute("account", new Account());
        model.addAttribute("accountTypes", accountTypeService.getAccountTypes());
        model.addAttribute("allcustomers", customerService.getAllCustomers());
        return "account/new";
    }

    @PostMapping(value = {"/fubc/account/new"})
    public String saveNewAccount(@Valid @ModelAttribute Account account, BindingResult bindingResult,
                                 Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "account/new";
        }
        Customer customer = customerService.getCustomer(account.getCustomerIdTransient());
        AccountType accountType = accountTypeService.getAccountType(account.getAccountTypeIdTransient());
        customer.getAccountList().add(account);
        accountType.getAccountList().add(account);
        account.setAccountType(accountType);
        account.setCustomer(customer);
        customer = customerService.saveNewCustomer(customer);
        return "redirect:/fubc/account/list";
    }

    @GetMapping(value = {"/fubc/account/liqudity"})
    public ModelAndView liquidity(){
        List<Account> accounts = accountService.listOfAllAccounts();
        List<AccountType> accountTypes = accountTypeService.getAccountTypes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("summary", accountService.summaryAccounts(accounts, accountTypes));
        modelAndView.setViewName("account/liqudity");
        return modelAndView;
    }


}
