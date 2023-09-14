package com.example.hans.greengrocer.repositories;

import com.example.hans.greengrocer.models.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Long> {
}
