package edu.mum.cs.cs425.fubcapplication.controller;

import edu.mum.cs.cs425.fubcapplication.model.AccountType;
import edu.mum.cs.cs425.fubcapplication.model.Customer;
import edu.mum.cs.cs425.fubcapplication.servirce.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AccountTypeController {
    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping(value = {"/fubc/accounttype/new"})
    public String displayNewCustomerForm(Model model){
        model.addAttribute("accountType", new AccountType());
        return "accounttype/new";
    }

    @PostMapping( value = {"/fubc/accounttype/new"})
    public String addNewCustomer(@Valid @ModelAttribute AccountType accountType, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "accounttype/new";
        }
        accountType = accountTypeService.saveAccountType(accountType);
        System.out.println(accountType);
        return "redirect:/fubc/accounttype/list";
    }

    @GetMapping(value = {"/fubc/accounttype/list"})
    public ModelAndView displayListOfAccounts(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accounts", accountTypeService.getAccountTypes());
        modelAndView.setViewName("accounttype/list");
        return modelAndView;
    }
}
