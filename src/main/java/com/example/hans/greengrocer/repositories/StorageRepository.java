package com.example.hans.greengrocer.repositories;

import com.example.hans.greengrocer.models.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
}
