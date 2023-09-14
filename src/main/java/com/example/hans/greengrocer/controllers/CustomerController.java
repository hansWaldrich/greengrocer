package com.example.hans.greengrocer.controllers;

import com.example.hans.greengrocer.models.Customer;
import com.example.hans.greengrocer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping(path = "/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        final Optional<Customer> customerCreated = service.createCustomer(customer);
        return customerCreated.map(cst -> ResponseEntity.status(HttpStatus.CREATED).body(cst)).orElseGet(() -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(customer));
    }

    @PutMapping(path = "/update-customer/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @RequestParam("id") Long id, @RequestBody Customer customer) {
        final Optional<Customer> updatedCustomer = service.updateCustomer(id, customer);
        return updatedCustomer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/find-customer/{id}")
    public ResponseEntity<Customer> findCustomer(@RequestParam("id") Long id) {
        final Optional<Customer> customer = service.findCustomer(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/delete-customer/{id}")
    public ResponseEntity<Customer> excludeCustomer(@RequestParam("id") Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
