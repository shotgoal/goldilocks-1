package org.objectworld.book.customer.web;

import java.util.List;

import org.objectworld.book.customer.domain.Customer;
import org.objectworld.book.customer.service.CustomerService;
import org.objectworld.book.customer.service.CustomerRepoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    private final CustomerService customerService;
    private final CustomerRepoService customerRepoService;

    public CustomerResource(CustomerService customerService,CustomerRepoService customerRepoService) {
        this.customerService = customerService;
        this.customerRepoService = customerRepoService;
    }

    @GetMapping
    public Iterable<Customer> findAll() {
        return this.customerService.findAll();
    }

    @GetMapping("/S1")
    public List<Customer> S1() {
        return this.customerRepoService.SelectCustMap();
    }
    @GetMapping("/S2")
    public Iterable<Customer> S2() {
        return this.customerService.findAll2();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return this.customerService.findById(id);
    }

    @GetMapping("/active")
    public List<Customer> findAllActive() {
        return this.customerService.findAllActive();
    }

    @GetMapping("/inactive")
    public List<Customer> findAllInactive() {
        return this.customerService.findAllInactive();
    }

    @PostMapping
    public Customer create(Customer Customer) {
        return this.customerService.create(Customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.customerService.delete(id);
    }
}