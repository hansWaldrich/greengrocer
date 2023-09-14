package com.example.hans.greengrocer.controllers;

import com.example.hans.greengrocer.models.Storage;
import com.example.hans.greengrocer.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/storages")
public class StorageController {

    @Autowired
    private StorageService service;

    @PostMapping(path = "/create")
    public ResponseEntity<Storage> createStorage(@RequestBody Storage storage) {
        final Optional<Storage> storageCreated = service.createStorage(storage);
        return storageCreated.map(stk -> ResponseEntity.status(HttpStatus.CREATED).body(stk)).orElseGet(() -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(storage));
    }

    @PutMapping(path = "/update-storage/{id}")
    public ResponseEntity<Storage> updateStorage(
            @RequestParam("id") Long id, @RequestBody Storage storage) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping(path = "/find-storage/{id}")
    public ResponseEntity<Storage> findStorage(@RequestParam("id") Long id) {
        final Optional<Storage> storage = service.findStorage(id);
        return storage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/delete-storage/{id}")
    public ResponseEntity<Storage> excludeStorage(@RequestParam("id") Long id) {
        service.deleteStorage(id);
        return ResponseEntity.ok().build();
    }
}
