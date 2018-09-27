package com.jtm.twiservice.controller;

import com.jtm.twiservice.Main;
import com.jtm.twiservice.model.Customer;
import com.jtm.twiservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
//    private static final Logger myLog = LoggerFactory.getLogger(Main.class);


    @Autowired //todo: What it does exactly?
    private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/customer")
    public String createCustomer(Customer customer) { // skasowalem parametr Model model i wszystko działa. Nie byl uzywany w metodzie, pewnie dlatego.
        customerRepository.save(customer);
//                // show records from repo
//        myLog.info("");
//        myLog.info("Customers found with findAll():");
//        myLog.info("-------------------------------");
//        for (Customer customerEmpty : customerRepository.findAll()) {
//            myLog.info(customerEmpty.toString());
//        }
//        myLog.info("");
        return "customer";
    }

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll()); //Ten atrybut jest potem używany przez thymeleaf do wyswietlania wynikow
                                                                            // w pierwszym argumentem w addAtribute() jest nazwa nowej zmiennej, a w drugim jej inicjalizacja
        return "customers";
    }

    @ModelAttribute("birthYears")
    public List<String> getBirthYears() {
        List<String> birthYears = new ArrayList<String>();
        birthYears.add("przed 2004");
        birthYears.add("2004");
        birthYears.add("2005");
        birthYears.add("2006");
        birthYears.add("2007");
        birthYears.add("2008");
        birthYears.add("2009");
        birthYears.add("2010");
        birthYears.add("2011");
        birthYears.add("2012");
        birthYears.add("2013");
        birthYears.add("2014");
        birthYears.add("po 2014");
        return birthYears;
    }

}

