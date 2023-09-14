package com.example.hans.greengrocer.DTOs;

import com.example.hans.greengrocer.models.Item;
import com.example.hans.greengrocer.models.StockItem;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockItemDto {

    private Long id;
    private StorageDto storage;
    private Item item;
    private Integer quantity;

    public StockItemDto(StockItem stockItem) {
        this.id = stockItem.getId();
        this.storage = new StorageDto(stockItem.getStorage());
        this.item = stockItem.getItem();
        this.quantity = stockItem.getQuantity();
    }
}
