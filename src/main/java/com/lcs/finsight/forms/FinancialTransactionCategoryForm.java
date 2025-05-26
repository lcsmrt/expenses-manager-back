package com.lcs.finsight.forms;

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
}
