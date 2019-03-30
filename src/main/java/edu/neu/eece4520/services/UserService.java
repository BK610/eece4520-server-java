package edu.neu.eece4520.services;

import edu.neu.eece4520.models.User;
import edu.neu.eece4520.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserService {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/user")
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
}
