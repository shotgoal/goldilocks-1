package org.objectworld.book.customer.service;

import java.util.List;

import org.objectworld.book.customer.domain.Customer;
import org.objectworld.book.customer.repository.CustomerRepo;
import org.objectworld.book.customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {
    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;
    

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
 

    public Customer create(Customer customer) {
        log.debug("Request to create Customer : {}", customer);
        return this.customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        log.debug("Request to get all Customers");
        return this.customerRepository.findAll();
    }
    public List<Customer> findAll2() {
        log.debug("Request to get all Customers2");
        return this.customerRepository.findAll2();
    }

    @Transactional(readOnly = true)
    public Customer findById(Long id) {
        log.debug("Request to get Customer : {}", id);
        return this.customerRepository.findById(id).get();
    }

    public List<Customer> findAllActive() {
        log.debug("Request to get all Customers");
        return this.customerRepository.findAllByEnabled(true);
    }

    public List<Customer> findAllInactive() {
        log.debug("Request to get all Customers");
        return this.customerRepository.findAllByEnabled(false);
    }

    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);

        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));

        customer.setEnabled(false);
        this.customerRepository.save(customer);
    }

    
}
