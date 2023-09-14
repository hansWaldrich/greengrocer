package com.example.hans.greengrocer.models;

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
public class Chart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chart_id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "chart")
    @JsonManagedReference
    private Set<ChartItem> items;
    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            @JoinColumn(name = "customer_phone_id", referencedColumnName = "phone")
    })
    private Customer customer;
    @Column
    private Double totalPrice;

    public Chart(Set<ChartItem> items, Customer customer, Double totalPrice) {
        this.items = items;
        this.customer = customer;
        this.totalPrice = totalPrice;
    }
}
