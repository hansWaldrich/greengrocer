package com.example.hans.greengrocer.controllers;

import com.example.hans.greengrocer.models.StockItem;
import com.example.hans.greengrocer.services.StockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stock-items")
public class StockItemController {

    @Autowired
    private StockItemService service;

    @PostMapping(path = "/create")
    public ResponseEntity<StockItem> createStockItem(@RequestBody StockItem stockItem) {
        final Optional<StockItem> stockItemCreated = service.createStockItem(stockItem);
        return stockItemCreated.map(stk -> ResponseEntity.status(HttpStatus.CREATED).body(stk)).orElseGet(() -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(stockItem));
    }

    @PutMapping(path = "/update-stockItem/{id}")
    public ResponseEntity<StockItem> updateStockItem(
            @RequestParam("id") Long id, @RequestBody StockItem stockItem) {
        final Optional<StockItem> updatedStockItem = service.updateStockItem(id, stockItem);
        return updatedStockItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/find-stockItem/{id}")
    public ResponseEntity<StockItem> findStockItem(@RequestParam("id") Long id) {
        final Optional<StockItem> stockItem = service.findStockItem(id);
        return stockItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/delete-stockItem/{id}")
    public ResponseEntity<StockItem> excludeStockItem(@RequestParam("id") Long id) {
        service.deleteStockItem(id);
        return ResponseEntity.ok().build();
    }
}
