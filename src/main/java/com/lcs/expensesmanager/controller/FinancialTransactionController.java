package com.lcs.expensesmanager.controller;

import com.lcs.expensesmanager.forms.FinancialTransactionForm;
import com.lcs.expensesmanager.model.FinancialTransaction;
import com.lcs.expensesmanager.services.FinancialTransactionService;
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
	public ResponseEntity<FinancialTransaction> getItem(@PathVariable Long id) {
		FinancialTransaction transaction = financialTransactionService.findById(id);
		return ResponseEntity.ok(transaction);
	}

	@GetMapping
	public ResponseEntity<List<FinancialTransaction>> getAllItems() {
		List<FinancialTransaction> transactions = financialTransactionService.findAll();
		return ResponseEntity.ok(transactions);
	}

	@PostMapping
	public ResponseEntity<FinancialTransaction> createItem(@RequestBody FinancialTransactionForm form) {
		FinancialTransaction transaction = financialTransactionService.save(form);
		return ResponseEntity.status(201).body(transaction);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FinancialTransaction> updateItem(@PathVariable Long id, @RequestBody FinancialTransactionForm form) {
		FinancialTransaction updatedTransaction = financialTransactionService.update(form, id);
		return ResponseEntity.ok(updatedTransaction);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
		financialTransactionService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
