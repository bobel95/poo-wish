package com.codecool.ratingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id @GeneratedValue
    private long id;

    private String name;

    private String email;

    private String phone;


}
