package com.lcs.finsight.controllers;

import com.lcs.finsight.dtos.request.FinancialTransactionCategoryRequestDto;
import com.lcs.finsight.models.FinancialTransactionCategory;
import com.lcs.finsight.services.FinancialTransactionCategoryService;
import com.lcs.finsight.utils.ApiRoutes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categorias de Transações Financeiras")
@RestController
@RequestMapping(ApiRoutes.FINANCIAL_TRANSACTION_CATEGORY)
public class FinancialTransactionCategoryController {

    private final FinancialTransactionCategoryService categoryService;

    public FinancialTransactionCategoryController(FinancialTransactionCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Busca uma categoria de transação pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<FinancialTransactionCategory> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @Operation(summary = "Busca todas as categorias de transação")
    @GetMapping
    public ResponseEntity<List<FinancialTransactionCategory>> getAllCategories() {
        List<FinancialTransactionCategory> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @Operation(summary = "Cria uma nova categoria de transação")
    @PostMapping
    public ResponseEntity<FinancialTransactionCategory> createCategory(@RequestBody @Valid FinancialTransactionCategoryRequestDto dto) {
        FinancialTransactionCategory createdCategory = categoryService.create(dto);
        return ResponseEntity.status(201).body(createdCategory);
    }

    @Operation(summary = "Atualiza uma categoria de transação")
    @PutMapping("/{id}")
    public ResponseEntity<FinancialTransactionCategory> updateCategory(@PathVariable Long id, @RequestBody @Valid FinancialTransactionCategoryRequestDto dto) {
        FinancialTransactionCategory updatedCategory = categoryService.update(id, dto);
        return ResponseEntity.ok(updatedCategory);
    }

    @Operation(summary = "Deleta uma categoria de transação")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
