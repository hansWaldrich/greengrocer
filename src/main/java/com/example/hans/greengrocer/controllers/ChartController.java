package com.example.hans.greengrocer.controllers;

import com.example.hans.greengrocer.DTOs.ChartDto;
import com.example.hans.greengrocer.models.Chart;
import com.example.hans.greengrocer.services.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/charts")
public class ChartController {

    @Autowired
    private ChartService service;

    @PostMapping(path = "/create")
    public ResponseEntity<Chart> createChart(@RequestBody Chart chart) {
        final Optional<Chart> chartCreated = service.createChart(chart);
        return chartCreated.map(crt -> ResponseEntity.status(HttpStatus.CREATED).body(crt)).orElseGet(() -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(chart));
    }

    @PutMapping(path = "/update-chart/{id}")
    public ResponseEntity<Chart> updateChart(
            @PathVariable(name = "id") Long id, @RequestBody Chart chart) {
        final Optional<Chart> updatedChart = service.updateChart(id, chart);
        return updatedChart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/find-chart/{id}")
    public ResponseEntity<ChartDto> findChart(@PathVariable(name = "id") Long id) {
        final Optional<ChartDto> chart = service.findChart(id);
        return chart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/delete-chart/{id}")
    public ResponseEntity<Chart> excludeChart(@PathVariable(name = "id") Long id) {
        service.deleteChart(id);
        return ResponseEntity.ok().build();
    }
}
