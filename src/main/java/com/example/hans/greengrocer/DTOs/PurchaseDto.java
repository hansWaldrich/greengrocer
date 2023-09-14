package com.example.hans.greengrocer.DTOs;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseDto {

    private Long id;
    private ChartDto chart;
    private Date purchaseDate;

}
