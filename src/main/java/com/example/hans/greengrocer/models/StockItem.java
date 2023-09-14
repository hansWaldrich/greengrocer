package com.example.hans.greengrocer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "storage_id", referencedColumnName = "id")
    private Storage storage;
    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;
    @Column
    private Integer quantity;

    public StockItem(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
