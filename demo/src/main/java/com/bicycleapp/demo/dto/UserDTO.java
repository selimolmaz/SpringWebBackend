package com.bicycleapp.demo.dto;

import com.bicycleapp.demo.model.User;

/**
 * Bu sınıf, bir kullanıcının adını, soyadını, e-posta adresini ve şifresini içeren bir veri transfer nesnesidir.
 * Ayrıca, UserDTO nesnesini User sınıfına dönüştürmek için toUser() metodu sağlanır.
 */
public class UserDTO {
    //UserDTO sınıfını oluşturduk: 
    //Kullanıcının adı, soyadı, e-posta ve şifre bilgilerini içeren bir veri transfer nesnesi.
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserDTO() {
    };

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    };

    public UserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User toUser() {
        User user = new User();
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
