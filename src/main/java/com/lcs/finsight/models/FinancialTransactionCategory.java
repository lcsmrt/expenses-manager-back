package com.lcs.finsight.models;

import com.lcs.finsight.forms.FinancialTransactionCategoryForm;
import jakarta.persistence.*;

import java.math.BigDecimal;

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
