package com.example.hans.greengrocer.services;

import com.example.hans.greengrocer.DTOs.ChartDto;
import com.example.hans.greengrocer.models.Chart;
import com.example.hans.greengrocer.repositories.ChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChartService {

    @Autowired
    private ChartRepository repository;

    public Optional<Chart> createChart(Chart chartToBeCreated){
        repository.save(chartToBeCreated);
        return Optional.of(chartToBeCreated);
    }

    public Optional<ChartDto> findChart(Long id){
        Optional<Chart> chart = repository.findById(id);

        return chart.map(value -> Optional.of(new ChartDto(value))).orElseGet(() -> Optional.of(new ChartDto()));

    }

    public Optional<Chart> updateChart(Long id, Chart chart){
        Optional<Chart> chartToUpdate = repository.findById(id);

        if(chartToUpdate.isPresent()){
            chartToUpdate.get().setItems(chart.getItems());
        } else {
            throw new RuntimeException("Chart not found");
        }

        return chartToUpdate;
    }

    public void deleteChart(Long id){
        repository.deleteById(id);
    }

}
