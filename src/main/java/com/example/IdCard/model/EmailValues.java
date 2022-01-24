package com.example.IdCard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class EmailValues {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String birthday;
    private String to;
}
