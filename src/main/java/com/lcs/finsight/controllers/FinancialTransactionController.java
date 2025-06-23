package com.lcs.finsight.controllers;

import com.lcs.finsight.dtos.request.FinancialTransactionRequestDto;
import com.lcs.finsight.models.FinancialTransaction;
import com.lcs.finsight.services.FinancialTransactionService;
import com.lcs.finsight.utils.ApiRoutes;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRoutes.FINANCIAL_TRANSACTION)
public class FinancialTransactionController {

	private final FinancialTransactionService financialTransactionService;

	public FinancialTransactionController(FinancialTransactionService financialTransactionService) {
		this.financialTransactionService = financialTransactionService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<FinancialTransaction> getTransaction(@PathVariable Long id) {
		FinancialTransaction transaction = financialTransactionService.findById(id);
		return ResponseEntity.ok(transaction);
	}

	@GetMapping
	public ResponseEntity<List<FinancialTransaction>> getAllTransactions() {
		List<FinancialTransaction> transactions = financialTransactionService.findAll();
		return ResponseEntity.ok(transactions);
	}

	@PostMapping
	public ResponseEntity<FinancialTransaction> createTransaction(@RequestBody @Valid FinancialTransactionRequestDto dto) {
		FinancialTransaction createdTransaction = financialTransactionService.create(dto);
		return ResponseEntity.status(201).body(createdTransaction);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FinancialTransaction> updateCategory(@PathVariable Long id, @RequestBody @Valid FinancialTransactionRequestDto dto) {
		FinancialTransaction updatedTransaction = financialTransactionService.update(id, dto);
		return ResponseEntity.ok(updatedTransaction);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
		financialTransactionService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
