package com.bicycleapp.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bicycleapp.demo.dto.UserDTO;
import com.bicycleapp.demo.model.User;
import com.bicycleapp.demo.service.UserService;

@Controller
@RequestMapping(path = "/userinfo")
public class UserInfoController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUserInformation(Model model) {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = new ArrayList<>();
        
        for (User user : users) {
            UserDTO userDTO = new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
            userDTOs.add(userDTO);
        }
        
        model.addAttribute("users", userDTOs);
        return "user-info";
    }

}
