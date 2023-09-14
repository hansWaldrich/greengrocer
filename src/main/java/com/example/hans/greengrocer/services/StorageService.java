package com.example.hans.greengrocer.services;

import com.example.hans.greengrocer.models.Item;
import com.example.hans.greengrocer.models.Storage;
import com.example.hans.greengrocer.repositories.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public Optional<Storage> createStorage(Storage storageToBeCreated){
        repository.save(storageToBeCreated);
        return Optional.of(storageToBeCreated);
    }

    public Optional<Storage> findStorage(Long id){
        return repository.findById(id);
    }

    public Optional<Storage> updateStorage(Long id, Storage storage, Item item){
        Optional<Storage> storageFromDB = repository.findById(id);

        if(storageFromDB.isPresent()){
            //TODO
        } else {
            throw new RuntimeException("Storage not found");
        }

        return storageFromDB;
    }

    public void deleteStorage(Long id){
        repository.deleteById(id);
    }

}
