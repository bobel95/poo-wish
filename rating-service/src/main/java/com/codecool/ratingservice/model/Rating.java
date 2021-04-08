package com.codecool.ratingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long id;
    private int rating;
    private String comment;
    private Long productId;
    private Long userId;
}
