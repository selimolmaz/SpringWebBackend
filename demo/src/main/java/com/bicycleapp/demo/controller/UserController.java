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

@Controller // Bu sınıfın bir Spring MVC Controller olduğunu belirtir.
@RequestMapping(path = "/register") // Bu Controller sınıfının "/register" URL'si altında çalışacağını belirtir.
public class UserController {

    @Autowired // Spring tarafından yönetilen ve enjekte edilmesi gereken bir nesne olduğunu belirtir.
    private UserService userService;

    @GetMapping // HTTP GET isteğine karşılık gelen bir Controller metodu olduğunu belirtir.
    public String showRegistrationForm(Model model) {
        // Model nesnesine "userDTO" adında bir UserDTO nesnesi ekler ve sayfanın adını "register-page" olarak belirler.
        model.addAttribute("userDTO", new UserDTO());
        return "register-page"; // "register-page" adlı bir sayfa döndürür.
    }

    @PostMapping("/users") // HTTP POST isteğine karşılık gelen bir Controller metodu olduğunu belirtir ve "/users" URL'si altında çalışacağını belirtir.
    public ResponseEntity<String> createUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) {
        // HTTP POST isteğiyle gönderilen firstName, lastName, email ve password parametrelerini kullanarak bir UserDTO nesnesi oluşturur.
        UserDTO userDTO = new UserDTO(firstName, lastName, email, password);
        try {
            // userService nesnesinin createUser() metodunu çağırır ve UserDTO nesnesini vererek yeni bir kullanıcı oluşturur.
            if (userService.createUser(userDTO) != null) {
                return ResponseEntity.ok("User Created Successfully!"); // HTTP 200 OK yanıtı döndürür ve "User Created Successfully!" mesajını içerir.
            }
        } catch (Exception e) {
            System.out.println(e); // Herhangi bir hata oluşursa konsola yazdırır.
        }
        return ResponseEntity.ok("User e-mail already exist!"); // HTTP 200 OK yanıtı döndürür ve "User e-mail already exist!" mesajını içerir.
    }
}
