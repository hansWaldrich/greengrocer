package com.example.hans.greengrocer.models;

import com.example.hans.greengrocer.models.composite.CustomerId;
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
@IdClass(CustomerId.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Id
    @Column
    private String phone;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
