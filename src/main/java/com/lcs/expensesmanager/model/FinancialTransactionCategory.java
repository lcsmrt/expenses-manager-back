package com.lcs.expensesmanager.model;

import java.math.BigDecimal;

import com.lcs.expensesmanager.forms.FinancialTransactionCategoryForm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "financial_transaction_categories")
public class FinancialTransactionCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal spendingLimit;

	public FinancialTransactionCategory() {
	}

	public FinancialTransactionCategory(FinancialTransactionCategoryForm form) {
		this.description = form.getDescription();
		this.spendingLimit = form.getSpendingLimit();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getSpendingLimit() {
		return spendingLimit;
	}

	public void setSpendingLimit(BigDecimal spendingLimit) {
		this.spendingLimit = spendingLimit;
	}

}
