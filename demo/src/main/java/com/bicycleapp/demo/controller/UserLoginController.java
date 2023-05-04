package com.bicycleapp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bicycleapp.demo.dto.UserDTO;
import com.bicycleapp.demo.service.UserService;
import org.springframework.ui.Model;


@Controller
@RequestMapping(path = "/signin")
public class UserLoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "login-page";
    }

    @PostMapping
    public ResponseEntity<String> checkUserForSignin(@RequestParam String email, @RequestParam String password) {
        boolean controllerFlag;
        UserDTO userDTO = new UserDTO(email, password);
        controllerFlag = userService.authenticate(userDTO.getEmail(), userDTO.getPassword());
        if (controllerFlag) {
            return ResponseEntity.ok("User Signin Successfully!");
        }
        return ResponseEntity.ok("User e-mail or password is not correct!");
    }
}
