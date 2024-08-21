package com.lcs.expensesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcs.expensesmanager.model.FinancialTransaction;
import com.lcs.expensesmanager.services.FinancialTransactionService;

@RestController
@RequestMapping("/api/expenses-manager/financial-transaction")
public class FinancialTransactionController {
	
	@Autowired
	private FinancialTransactionService financialTransactionService;

	@GetMapping("/{id}")
	public FinancialTransaction getItem(@PathVariable Long id) {
		return financialTransactionService.findById(id);
	}
}
