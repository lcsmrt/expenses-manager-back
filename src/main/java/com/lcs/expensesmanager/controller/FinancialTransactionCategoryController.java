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

import com.lcs.expensesmanager.forms.FinancialTransactionCategoryForm;
import com.lcs.expensesmanager.model.FinancialTransactionCategory;
import com.lcs.expensesmanager.services.FinancialTransactionCategoryService;

@RestController
@RequestMapping("/api/expenses-manager/financial-transaction-category")
public class FinancialTransactionCategoryController {

	@Autowired
	private FinancialTransactionCategoryService financialTransactionCategoryService;

	@GetMapping("/{id}")
	public ResponseEntity<FinancialTransactionCategory> getCategory(@PathVariable Long id) {
		return ResponseEntity.ok(financialTransactionCategoryService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<FinancialTransactionCategory>> getAllCategories() {
		List<FinancialTransactionCategory> categories = financialTransactionCategoryService.findAll();
		return ResponseEntity.ok(categories);
	}

	@PostMapping
	public ResponseEntity<FinancialTransactionCategory> createCategory(@RequestBody FinancialTransactionCategoryForm categoryForm) {
		FinancialTransactionCategory createdCategory = financialTransactionCategoryService.save(categoryForm);
		return ResponseEntity.status(201).body(createdCategory);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FinancialTransactionCategory> updateCategory(@RequestBody FinancialTransactionCategoryForm categoryForm, @PathVariable Long id) {
		FinancialTransactionCategory updatedCategory = financialTransactionCategoryService.update(categoryForm, id);
		return ResponseEntity.ok(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		financialTransactionCategoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
