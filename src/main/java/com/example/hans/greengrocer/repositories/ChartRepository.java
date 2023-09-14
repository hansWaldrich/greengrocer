package com.example.hans.greengrocer.repositories;

import com.example.hans.greengrocer.models.Chart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartRepository extends JpaRepository<Chart, Long> {
}
