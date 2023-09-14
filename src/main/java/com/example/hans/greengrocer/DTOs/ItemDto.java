package com.example.hans.greengrocer.DTOs;

import com.example.hans.greengrocer.enums.ItemType;
import com.example.hans.greengrocer.models.Item;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDto {

    private Long id;
    private Set<ChartItemDto> charts;
    private String name;
    private String vendor;
    private Double price;
    private ItemType type;

    public ItemDto(Item item) {
        this.id = item.getId();
        this.charts = item.getCharts().stream().map(ChartItemDto::new).collect(Collectors.toSet());
        this.name = item.getName();
        this.vendor = item.getVendor();
        this.price = item.getPrice();
        this.type = item.getType();
    }
}
