package com.lcs.expensesmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcs.expensesmanager.forms.CategoryForm;
import com.lcs.expensesmanager.model.Category;
import com.lcs.expensesmanager.services.CategoryService;

@RestController
@RequestMapping("/api/expenses-manager/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable Long id) {
		return ResponseEntity.ok(categoryService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categories = categoryService.findAll();
		return ResponseEntity.ok(categories);
	}

	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody CategoryForm categoryForm) {
		Category createdCategory = categoryService.save(categoryForm);
		return ResponseEntity.status(201).body(createdCategory);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@RequestBody CategoryForm categoryForm, @PathVariable Long id) {
		Category updatedCategory = categoryService.update(categoryForm, id);
		return ResponseEntity.ok(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
