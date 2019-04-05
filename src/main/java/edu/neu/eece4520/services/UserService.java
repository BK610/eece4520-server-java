package edu.neu.eece4520.services;

import edu.neu.eece4520.models.User;
import edu.neu.eece4520.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/user/{userId}")
    public User findUserById(
            @PathVariable("userId") Integer id) {
        return userRepository.findUserById(id);
    }

    @GetMapping("/api/user/exists/{userId}")
    public Boolean checkUserExists(
            @PathVariable("userId") Integer id) {
        User user = userRepository.findUserById(id);
        return !(user == null);
    }

    @PostMapping("/api/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/api/user/{userId}")
    public User updateUser(
            @PathVariable("userId") Integer id,
            @RequestBody User userUpdates) {
        User user = userRepository.findUserById(id);
        //TODO: Set all fields
        //user.setField(userUpdates.getField());
        return userRepository.save(user);
    }

    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(
            @PathVariable("userId") Integer id) {
        userRepository.deleteById(id);
    }
}
