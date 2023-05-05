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

@Controller // Bu sınıfın bir Spring Controller olduğunu belirtir
@RequestMapping(path = "/userinfo") // Bu Controller'ın requestlerinin hangi URL altında ele alınacağını belirtir
public class UserInfoController {
    
    @Autowired // Spring'in dependency injection yapısını kullanarak UserService sınıfını bu Controller'a inject etmesini sağlar
    private UserService userService;

    // GET requestleri için "/userinfo" URL'i altında tüm kullanıcıların bilgilerini döndüren bir endpoint tanımlar
    @RequestMapping(method = RequestMethod.GET)
    public String getAllUserInformation(Model model) {
        // UserService aracılığıyla tüm kullanıcıları alır
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = new ArrayList<>();
        
        // Tüm kullanıcıları UserDTO nesnelerine dönüştürür
        for (User user : users) {
            UserDTO userDTO = new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
            userDTOs.add(userDTO);
        }
        
        // UserDTO listesini "users" ismiyle view tarafına gönderir
        model.addAttribute("users", userDTOs);
        // user-info.html view'ını döndürür
        return "user-info";
    }
}
