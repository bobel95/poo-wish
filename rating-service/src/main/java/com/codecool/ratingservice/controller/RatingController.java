package com.codecool.ratingservice.controller;

import com.codecool.ratingservice.model.Rating;
import com.codecool.ratingservice.model.UserRatings;
import com.codecool.ratingservice.repository.RatingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingRepository ratingRepository;

    public RatingController(RatingRepository ratingRepository) {

        this.ratingRepository = ratingRepository;
    }

    @GetMapping
    public List<Rating> getProducts() {
        return ratingRepository.findAll();
    }

//    @GetMapping("/{userId}/{ratingId}/{productId}")
//    public Rating getRatingByProductId(@PathVariable("productId") Long productId,
//                                       @PathVariable("userId") Long userId,
//                                       @PathVariable("ratingId") Long ratingId) {
//        return ratingRepository.findById(ratingId)
//                .orElseThrow(IllegalArgumentException::new);
//    }

    @GetMapping("/{userId}")
    public UserRatings getRatingsByUser(@PathVariable("userId") Long userId) {
        return new UserRatings(
            ratingRepository.findAllByUserId(userId)
        );
    }

    @PostMapping
    public Rating addRating(@RequestBody Rating rating) {

        return ratingRepository.save(rating);
    }

    @PutMapping()
    public Rating updateProduct(@RequestBody Rating rating) {

        return ratingRepository.save(rating);
    }

    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") Long ratingId) {

        ratingRepository.deleteById(ratingId);
    }
}
