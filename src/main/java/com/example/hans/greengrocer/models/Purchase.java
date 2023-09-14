package com.example.hans.greengrocer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "chart_id")
    private Chart chart;
    @Column
    private Date purchaseDate;

    public Purchase(Chart chart, Date purchaseDate) {
        this.chart = chart;
        this.purchaseDate = purchaseDate;
    }
}
