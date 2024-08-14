package com.lcs.expensesmanager.forms;

import java.math.BigDecimal;

import com.lcs.expensesmanager.model.Category;

import jakarta.validation.constraints.NotBlank;

public class CategoryForm {
	@NotBlank(message = "A descrição não pode ser vazia.")
	private String description;
	private BigDecimal spendingLimit;

	public String getDescription() {
		return description;
	}

	public BigDecimal getSpendingLimit() {
		return spendingLimit;
	}
	
	public Category update(Category category) {
		category.setDescription(description);
		category.setSpendingLimit(spendingLimit);
		
		return category;
	}
}
