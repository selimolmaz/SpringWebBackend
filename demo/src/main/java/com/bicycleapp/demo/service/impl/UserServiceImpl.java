package com.bicycleapp.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicycleapp.demo.dto.UserDTO;
import com.bicycleapp.demo.model.User;
import com.bicycleapp.demo.repository.UserRepository;
import com.bicycleapp.demo.service.UserService;

/**
 * Bu sınıf, UserService arayüzünün uygulanmasıdır.
 * Bu sınıf, UserRepository kullanarak CRUD işlemlerini gerçekleştirir.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * UserDTO nesnesini kullanarak yeni bir kullanıcı oluşturur.
     * Eğer kullanıcı daha önce aynı e-posta adresiyle kaydedilmişse, null döndürür.
     * 
     * @param userDTO Oluşturulacak kullanıcının bilgilerini içeren UserDTO nesnesi
     * @return Kaydedilen kullanıcıyı temsil eden User nesnesi
     */
    @Override
    public User createUser(UserDTO userDTO) {
        if (getUserByEmail(userDTO.getEmail()) != null) {
            return null;
        }
        User user = userDTO.toUser();
        return userRepository.save(user);
    }

    /**
     * Tüm kullanıcıları getirir.
     * 
     * @return Kullanıcıları temsil eden User nesnelerinin listesi
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Verilen id'ye sahip kullanıcıyı getirir.
     * 
     * @param id Kullanıcının id'si
     * @return İstenen kullanıcıyı temsil eden User nesnesi
     */
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Verilen id'ye sahip kullanıcıyı siler.
     * 
     * @param id Kullanıcının id'si
     */
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Kullanıcıyı kaydeder.
     * 
     * @param user Kaydedilecek kullanıcıyı temsil eden User nesnesi
     * @return Kaydedilen kullanıcıyı temsil eden User nesnesi
     */
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * Verilen e-posta ve şifreyle kimlik doğrulaması yapar.
     * 
     * @param email    Kullanıcının e-posta adresi
     * @param password Kullanıcının şifresi
     * @return Kimlik doğrulaması başarılıysa true, aksi takdirde false
     */
    @Override
    public boolean authenticate(String email, String password) {

        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null && user.getPassword().equals(password) && user.getEmail().equals(email)) {
            return true; // doğrulama başarılı
        }
        return false; // doğrulama başarısız
    }

    /**
     * Verilen e-posta adresine sahip kullanıcıyı getirir.
     * 
     * @param email Kullanıcının e-posta adresi
     * @return İstenen kullanıcıyı temsil eden User nesnesi
     */
    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
