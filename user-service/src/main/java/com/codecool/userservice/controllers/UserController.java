package com.codecool.userservice.controllers;

import com.codecool.ratingservice.model.User;
import com.codecool.userservice.models.ResponseObject;
import com.codecool.userservice.models.UserModel;
import com.codecool.userservice.models.UserProducts;
import com.codecool.userservice.models.UserRatings;
import com.codecool.userservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class UserController {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @RequestMapping("/user/{userId}")
    public ResponseObject getUserById (@PathVariable("userId") Long userId) {

        UserRatings ratings = restTemplate.getForObject(
            "http://rating-service/rating/" + userId,
            UserRatings.class
        );

        UserProducts products = restTemplate.getForObject(
            "http://product-service/product/user/" + userId,
            UserProducts.class
        );

        UserModel user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);

        return new ResponseObject(user, ratings, products);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    public UserModel addUser (@RequestBody UserModel userModel) {
        return userRepository.save(userModel);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/user/{id}")
    public void deleteUser (@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/user/{id}")
    public UserModel updateUser (@PathVariable("id") long id, @RequestBody UserModel userModel) {
        UserModel userToUpdate = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        userToUpdate.setEmail(userModel.getEmail());
        userToUpdate.setName(userModel.getName());
        userToUpdate.setPhone(userModel.getPhone());

        return userRepository.save(userToUpdate);
    }

}
