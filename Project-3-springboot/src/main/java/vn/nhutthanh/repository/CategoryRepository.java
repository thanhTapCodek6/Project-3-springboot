package vn.nhutthanh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.nhutthanh.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByNameContainingIgnoreCase(String name);
}