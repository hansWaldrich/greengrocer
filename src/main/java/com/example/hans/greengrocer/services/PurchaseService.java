package com.example.hans.greengrocer.services;

import com.example.hans.greengrocer.models.Purchase;
import com.example.hans.greengrocer.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository repository;

    public Optional<Purchase> createPurchase(Purchase purchaseToBeCreated){
        repository.save(purchaseToBeCreated);
        return Optional.of(purchaseToBeCreated);
    }

    public Optional<Purchase> findPurchase(Long id){
        return repository.findById(id);
    }

    public void deletePurchase(Long id){
        repository.deleteById(id);
    }

}
