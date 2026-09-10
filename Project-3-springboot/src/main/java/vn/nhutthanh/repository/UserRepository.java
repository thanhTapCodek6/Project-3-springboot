package vn.nhutthanh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.nhutthanh.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUsernameContainingIgnoreCase(String username);
}