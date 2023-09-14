package com.example.hans.greengrocer.controllers;

import com.example.hans.greengrocer.models.Item;
import com.example.hans.greengrocer.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping(path = "/create")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        final Optional<Item> itemCreated = service.createItem(item);
        return itemCreated.map(itm -> ResponseEntity.status(HttpStatus.CREATED).body(itm)).orElseGet(() -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(item));
    }

    @PutMapping(path = "/update-item/{id}")
    public ResponseEntity<Item> updateItem(
            @RequestParam("id") Long id, @RequestBody Item item) {
        final Optional<Item> updatedItem = service.updateItem(id, item);
        return updatedItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/find-item/{id}")
    public ResponseEntity<Item> findItem(@RequestParam("id") Long id) {
        final Optional<Item> item = service.findItem(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/delete-item/{id}")
    public ResponseEntity<Item> excludeItem(@RequestParam("id") Long id) {
        service.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}
