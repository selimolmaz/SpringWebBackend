package com.bicycleapp.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bicycleapp.demo.dto.UserDTO;
import com.bicycleapp.demo.model.User;
import com.bicycleapp.demo.service.UserService;

@Controller
@RequestMapping(path = "/register")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register-page";
    }
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) {
        UserDTO userDTO = new UserDTO(firstName, lastName, email, password);
        User createdUserForRegister = userService.createUser(userDTO);
        if (createdUserForRegister != null) {
            return ResponseEntity.ok("User Created Successfully!");
        }
        return ResponseEntity.ok("User e-mail already exist!");
    }

    // @PostMapping("/users")
    // public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
    //     userService.createUser(userDTO);
    //     return ResponseEntity.ok("User created successfully!");
    // }

    // @GetMapping("/users/{id}")
    // public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
    //     User user = userService.getUserById(id);
    //     UserDTO userDTO = new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    //     return ResponseEntity.ok(userDTO);
    // }

}