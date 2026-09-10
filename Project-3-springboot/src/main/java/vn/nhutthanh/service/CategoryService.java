package vn.nhutthanh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.nhutthanh.entity.Category;
import vn.nhutthanh.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> search(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }
}