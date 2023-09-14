package com.example.hans.greengrocer.DTOs;

import com.example.hans.greengrocer.models.Chart;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChartDto {

    private Long id;
    private List<ChartItemDto> items;
    private CustomerDto customer;
    private Double totalPrice;

    public ChartDto(Chart chart) {
        this.id = chart.getId();
        this.items = chart.getItems().stream().map(ChartItemDto::new).collect(Collectors.toList());
        this.customer = new CustomerDto(chart.getCustomer());
        this.totalPrice = chart.getTotalPrice();
    }
}
