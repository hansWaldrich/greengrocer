package com.example.hans.greengrocer.controllers;

import com.example.hans.greengrocer.models.Purchase;
import com.example.hans.greengrocer.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @PostMapping(path = "/create")
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        final Optional<Purchase> purchaseCreated = service.createPurchase(purchase);
        return purchaseCreated.map(pur -> ResponseEntity.status(HttpStatus.CREATED).body(pur)).orElseGet(() -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(purchase));
    }

    @PutMapping(path = "/update-purchase/{id}")
    public ResponseEntity<Purchase> updatePurchase(
            @RequestParam("id") Long id, @RequestBody Purchase purchase) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping(path = "/find-purchase/{id}")
    public ResponseEntity<Purchase> findPurchase(@RequestParam("id") Long id) {
        final Optional<Purchase> purchase = service.findPurchase(id);
        return purchase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/delete-purchase/{id}")
    public ResponseEntity<Purchase> excludePurchase(@RequestParam("id") Long id) {
        service.deletePurchase(id);
        return ResponseEntity.ok().build();
    }
}
