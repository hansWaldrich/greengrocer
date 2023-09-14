package com.example.hans.greengrocer.models.composite;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerId implements Serializable {

    private Long id;
    private String phone;

    public CustomerId(Long id, String phone) {
        this.id = id;
        this.phone = phone;
    }
}
