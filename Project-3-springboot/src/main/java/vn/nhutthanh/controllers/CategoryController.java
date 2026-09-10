package vn.nhutthanh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.nhutthanh.entity.Category;
import vn.nhutthanh.service.CategoryService;

@Controller
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/admin/category")
	public String category(@RequestParam(required = false) String keyword, Model model) {

		if (keyword == null || keyword.isBlank()) {
			model.addAttribute("categories", categoryService.findAll());
		} else {
			model.addAttribute("categories", categoryService.search(keyword));
		}

		model.addAttribute("keyword", keyword);

		return "admin/category";
	}

	@PostMapping("/admin/category/add")
	public String addCategory(@RequestParam String name) {
		Category category = new Category();
		category.setName(name);

		categoryService.save(category);

		return "redirect:/admin/category";
	}

	@GetMapping("/admin/category/edit")
	public String editCategory(@RequestParam int id, Model model) {
		Category category = categoryService.findById(id);

		model.addAttribute("category", category);

		return "admin/category-edit";
	}

	@PostMapping("/admin/category/edit")
	public String updateCategory(@RequestParam int id, @RequestParam String name) {

		Category category = categoryService.findById(id);
		category.setName(name);

		categoryService.save(category);

		return "redirect:/admin/category";
	}

	@GetMapping("/admin/category/delete")
	public String deleteCategory(@RequestParam int id) {
		categoryService.deleteById(id);
		return "redirect:/admin/category";
	}
}