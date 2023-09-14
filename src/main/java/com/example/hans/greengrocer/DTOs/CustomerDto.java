package com.example.hans.greengrocer.DTOs;

import com.example.hans.greengrocer.models.Customer;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {

    private Long id;
    private String name;
    private String phone;

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.phone = customer.getPhone();
    }
}
