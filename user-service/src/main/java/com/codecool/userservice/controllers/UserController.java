package com.codecool.userservice.controllers;

import com.codecool.userservice.models.UserModel;
import com.codecool.userservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class UserController {

    private final UserRepository userRepository;

    @RequestMapping("/user/{email}")
    public UserModel getUserById (@PathVariable("email") String email) {
        return userRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
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
