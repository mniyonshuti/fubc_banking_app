package edu.mum.cs.cs425.fubcapplication.controller;

import edu.mum.cs.cs425.fubcapplication.model.Customer;
import edu.mum.cs.cs425.fubcapplication.servirce.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/fubc/customer/list"})
    public ModelAndView displayCustomers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", customerService.getAllCustomers());
        modelAndView.setViewName("customer/list");
        return modelAndView;
    }

    @GetMapping(value = {"/fubc/customer/new"})
    public String displayNewCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/new";
    }

    @PostMapping( value = {"/fubc/customer/new"})
    public String addNewCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer/new";
        }
        customer = customerService.saveNewCustomer(customer);
        System.out.println(customer);
        return "redirect:/fubc/customer/list";
    }

}
