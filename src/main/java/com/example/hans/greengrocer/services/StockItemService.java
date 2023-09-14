package com.example.hans.greengrocer.services;

import com.example.hans.greengrocer.models.StockItem;
import com.example.hans.greengrocer.repositories.StockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockItemService {

    @Autowired
    private StockItemRepository repository;

    public Optional<StockItem> createStockItem(StockItem stockItemToBeCreated){
        repository.save(stockItemToBeCreated);
        return Optional.of(stockItemToBeCreated);
    }

    public Optional<StockItem> findStockItem(Long id){
        return repository.findById(id);
    }

    public Optional<StockItem> updateStockItem(Long id, StockItem stockItem){
        Optional<StockItem> stockItemFromDB = repository.findById(id);

        if(stockItemFromDB.isPresent()){

            stockItemFromDB.get().setItem(stockItem.getItem());
            stockItemFromDB.get().setQuantity(stockItem.getQuantity());

            repository.save(stockItemFromDB.get());

        } else {
            throw new RuntimeException("StockItem not found");
        }

        return stockItemFromDB;
    }

    public void deleteStockItem(Long id){
        repository.deleteById(id);
    }

}
