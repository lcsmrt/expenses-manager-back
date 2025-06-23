package com.lcs.finsight.dtos.request;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class FinancialTransactionCategoryRequestDto {

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
