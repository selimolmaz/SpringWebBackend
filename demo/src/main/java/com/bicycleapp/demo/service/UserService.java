package com.bicycleapp.demo.service;

import java.util.List;

import com.bicycleapp.demo.dto.UserDTO;
import com.bicycleapp.demo.model.User;

public interface UserService {
	// Create User
    public User createUser(UserDTO userDTO);

    // Get all users from the database
    List<User> getAllUsers();

    // Get user by id
    User getUserById(Long id);

    // Get user by email
    User getUserByEmail(String email);

    // Delete user by id
    void deleteUserById(Long id);

    // Save user
    User save(User user);

    // User authenticate 
    public boolean authenticate(String email, String password);
}
