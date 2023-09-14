package com.example.hans.greengrocer.services;

import com.example.hans.greengrocer.models.Customer;
import com.example.hans.greengrocer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Optional<Customer> createCustomer(Customer customerToBeCreated){
        repository.save(customerToBeCreated);
        return Optional.of(customerToBeCreated);
    }

    public Optional<Customer> findCustomer(Long id){
        return repository.findById(id);
    }

    public Optional<Customer> updateCustomer(Long id, Customer customer){
        Optional<Customer> customerToUpdate = repository.findById(id);

        if(customerToUpdate.isPresent()){

            customerToUpdate.get().setName(customer.getName());
            customerToUpdate.get().setPhone(customer.getPhone());

            repository.save(customerToUpdate.get());

        } else {
            throw new RuntimeException("Customer not found");
        }

        return customerToUpdate;
    }

    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }

}
