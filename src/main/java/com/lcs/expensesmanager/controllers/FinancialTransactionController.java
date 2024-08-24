package com.lcs.expensesmanager.controllers;

import com.lcs.expensesmanager.forms.FinancialTransactionForm;
import com.lcs.expensesmanager.models.FinancialTransaction;
import com.lcs.expensesmanager.services.FinancialTransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses-manager/financial-transaction")
public class FinancialTransactionController {
	
	@Autowired
	private FinancialTransactionService financialTransactionService;

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
	public ResponseEntity<FinancialTransaction> createTransaction(@RequestBody @Valid FinancialTransactionForm form) {
		FinancialTransaction createdTransaction = financialTransactionService.create(form);
		return ResponseEntity.status(201).body(createdTransaction);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FinancialTransaction> updateCategory(@PathVariable Long id, @RequestBody @Valid FinancialTransactionForm form) {
		FinancialTransaction updatedTransaction = financialTransactionService.update(id, form);
		return ResponseEntity.ok(updatedTransaction);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
		financialTransactionService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
