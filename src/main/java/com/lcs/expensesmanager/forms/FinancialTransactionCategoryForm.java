package com.lcs.expensesmanager.forms;

import com.lcs.expensesmanager.model.FinancialTransactionCategory;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class FinancialTransactionCategoryForm {

	@NotBlank(message = "A descrição não pode ser vazia.")
	private String description;

	private BigDecimal spendingLimit;

	public String getDescription() {
		return description;
	}

	public BigDecimal getSpendingLimit() {
		return spendingLimit;
	}
	
	public FinancialTransactionCategory update(FinancialTransactionCategory category) {
		category.setDescription(description);
		category.setSpendingLimit(spendingLimit);
		
		return category;
	}
}
