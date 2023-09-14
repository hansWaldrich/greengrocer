package com.example.hans.greengrocer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ChartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chart_item_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "chart_id")
    @JsonBackReference
    private Chart chart;
    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonBackReference
    private Item item;
    @Column(name = "quantity")
    private Integer quantity;

}
