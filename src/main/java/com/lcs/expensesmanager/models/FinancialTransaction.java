package com.lcs.expensesmanager.models;

import com.lcs.expensesmanager.forms.FinancialTransactionForm;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financial_transactions")
public class FinancialTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private FinancialTransactionCategory category;

	@Enumerated(EnumType.STRING)
	private FinancialTransactionType type;

	private BigDecimal amount;
	private String description;
	private String frequency;
	private String parcelsNumber;
	private LocalDate startDate;
	private LocalDate endDate;

	public FinancialTransaction() {
	}

	public FinancialTransaction(FinancialTransactionForm form) {
		this.category = form.getCategory();
		this.type = form.getType();
		this.amount = form.getAmount();
		this.description = form.getDescription();
		this.frequency = form.getFrequency();
		this.parcelsNumber = form.getParcelsNumber();
		this.startDate = form.getStartDate();
		this.endDate = form.getEndDate();
	}

	public Long getId() {
		return id;
	}

	public FinancialTransactionCategory getCategory() {
		return category;
	}

	public void setCategory(FinancialTransactionCategory category) {
		this.category = category;
	}

	public FinancialTransactionType getType() {
		return type;
	}

	public void setType(FinancialTransactionType type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getParcelsNumber() {
		return parcelsNumber;
	}

	public void setParcelsNumber(String parcelsNumber) {
		this.parcelsNumber = parcelsNumber;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}