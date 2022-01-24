package com.example.IdCard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class EmailValues {
    String name;
    String surname;
    String phone;
    String email;
    String birthday;
    String to;
}
