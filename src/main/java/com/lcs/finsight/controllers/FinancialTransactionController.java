package com.lcs.finsight.controllers;

import com.lcs.finsight.dtos.request.FinancialTransactionRequestDto;
import com.lcs.finsight.models.FinancialTransaction;
import com.lcs.finsight.services.FinancialTransactionService;
import com.lcs.finsight.utils.ApiRoutes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Transações Financeiras")
@RestController
@RequestMapping(ApiRoutes.FINANCIAL_TRANSACTION)
public class FinancialTransactionController {

	private final FinancialTransactionService financialTransactionService;

	public FinancialTransactionController(FinancialTransactionService financialTransactionService) {
		this.financialTransactionService = financialTransactionService;
	}

	@Operation(summary = "Busca uma transação pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<FinancialTransaction> getTransaction(@PathVariable Long id) {
		FinancialTransaction transaction = financialTransactionService.findById(id);
		return ResponseEntity.ok(transaction);
	}

	@Operation(summary = "Busca todas as transações")
	@GetMapping
	public ResponseEntity<List<FinancialTransaction>> getAllTransactions() {
		List<FinancialTransaction> transactions = financialTransactionService.findAll();
		return ResponseEntity.ok(transactions);
	}

	@Operation(summary = "Cria uma nova transação")
	@PostMapping
	public ResponseEntity<FinancialTransaction> createTransaction(@RequestBody @Valid FinancialTransactionRequestDto dto) {
		FinancialTransaction createdTransaction = financialTransactionService.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
	}

	@Operation(summary = "Atualiza uma transação")
	@PutMapping("/{id}")
	public ResponseEntity<FinancialTransaction> updateCategory(@PathVariable Long id, @RequestBody @Valid FinancialTransactionRequestDto dto) {
		FinancialTransaction updatedTransaction = financialTransactionService.update(id, dto);
		return ResponseEntity.ok(updatedTransaction);
	}

	@Operation(summary = "Deleta uma transação")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
		financialTransactionService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
