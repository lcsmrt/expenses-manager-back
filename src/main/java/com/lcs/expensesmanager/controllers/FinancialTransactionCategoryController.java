package com.lcs.expensesmanager.controllers;

import com.lcs.expensesmanager.forms.FinancialTransactionCategoryForm;
import com.lcs.expensesmanager.models.FinancialTransactionCategory;
import com.lcs.expensesmanager.services.FinancialTransactionCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<FinancialTransactionCategory> createCategory(@RequestBody @Valid FinancialTransactionCategoryForm categoryForm) {
        FinancialTransactionCategory createdCategory = financialTransactionCategoryService.create(categoryForm);
        return ResponseEntity.status(201).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinancialTransactionCategory> updateCategory(@PathVariable Long id, @RequestBody @Valid FinancialTransactionCategoryForm categoryForm) {
        FinancialTransactionCategory updatedCategory = financialTransactionCategoryService.update(id, categoryForm);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        financialTransactionCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
