package com.example.hans.greengrocer.DTOs;

import com.example.hans.greengrocer.models.Storage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StorageDto {

    private Long id;
    private String name;
    private List<StockItemDto> items;

    public StorageDto(Storage storage) {
        this.id = storage.getId();
        this.name = storage.getName();
        this.items = storage.getItems().stream().map(StockItemDto::new).collect(Collectors.toList());
    }
    public StorageDto(List<StockItemDto> items) {
        this.items = items;
    }
}
