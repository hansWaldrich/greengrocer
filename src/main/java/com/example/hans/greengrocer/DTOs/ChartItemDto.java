package com.example.hans.greengrocer.DTOs;

import com.example.hans.greengrocer.models.ChartItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChartItemDto {

    private Long id;
    @JsonIgnore
    private ChartDto chart;
    @JsonIgnore
    private ItemDto item;
    private Long chartId;
    private Long itemId;
    private Double itemPrice;
    private Integer quantity;

    public ChartItemDto(ChartItem chartItem) {
        this.id = chartItem.getId();
        this.chartId = chartItem.getChart().getId();
        this.itemId = chartItem.getItem().getId();
        this.itemPrice = chartItem.getItem().getPrice();
        this.quantity = chartItem.getQuantity();
    }
}
