package com.example.hans.greengrocer.services;

import com.example.hans.greengrocer.models.Item;
import com.example.hans.greengrocer.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Optional<Item> createItem(Item itemToBeCreated){
        repository.save(itemToBeCreated);
        return Optional.of(itemToBeCreated);
    }

    public Optional<Item> findItem(Long id){
        return repository.findById(id);
    }

    public Optional<Item> updateItem(Long id, Item item){
        Optional<Item> itemToUpdate = repository.findById(id);

        if(itemToUpdate.isPresent()){
            itemToUpdate.get().setName(item.getName());
            itemToUpdate.get().setVendor(item.getVendor());
            itemToUpdate.get().setPrice(item.getPrice());
            itemToUpdate.get().setType(item.getType());
            repository.save(itemToUpdate.get());
        } else {
            throw new RuntimeException("Item not found");
        }

        return itemToUpdate;
    }

    public void deleteItem(Long id){
        repository.deleteById(id);
    }

}
