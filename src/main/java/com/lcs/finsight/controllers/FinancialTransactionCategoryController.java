package com.lcs.finsight.controllers;

import com.lcs.finsight.dtos.request.FinancialTransactionCategoryRequestDto;
import com.lcs.finsight.models.FinancialTransactionCategory;
import com.lcs.finsight.services.FinancialTransactionCategoryService;
import com.lcs.finsight.utils.ApiRoutes;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRoutes.FINANCIAL_TRANSACTION_CATEGORY)
public class FinancialTransactionCategoryController {

    private final FinancialTransactionCategoryService categoryService;

    public FinancialTransactionCategoryController(FinancialTransactionCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialTransactionCategory> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<FinancialTransactionCategory>> getAllCategories() {
        List<FinancialTransactionCategory> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<FinancialTransactionCategory> createCategory(@RequestBody @Valid FinancialTransactionCategoryRequestDto dto) {
        FinancialTransactionCategory createdCategory = categoryService.create(dto);
        return ResponseEntity.status(201).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinancialTransactionCategory> updateCategory(@PathVariable Long id, @RequestBody @Valid FinancialTransactionCategoryRequestDto dto) {
        FinancialTransactionCategory updatedCategory = categoryService.update(id, dto);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
