package vn.nhutthanh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.nhutthanh.entity.User;
import vn.nhutthanh.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public List<User> search(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username);
    }
}