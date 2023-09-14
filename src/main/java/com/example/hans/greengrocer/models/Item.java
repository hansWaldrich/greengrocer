package com.example.hans.greengrocer.models;

import com.example.hans.greengrocer.enums.ItemType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "item")
    @JsonManagedReference
    private Set<ChartItem> charts;
    @Column
    private String name;
    @Column
    private String vendor;
    @Column
    private Double price;
    @Enumerated(EnumType.STRING)
    @Column(name = "item_type", nullable = false)
    private ItemType type;

    public Item(String name, String vendor, Double price, ItemType type) {
        this.name = name;
        this.vendor = vendor;
        this.price = price;
        this.type = type;
    }

}
