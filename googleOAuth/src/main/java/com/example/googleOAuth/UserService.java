package com.example.googleOAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUserToDatabase(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        userRepository.save(user);
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null); // Returns null if user not found
    }
}
