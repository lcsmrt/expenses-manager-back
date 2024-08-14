package com.lcs.expensesmanager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	@ManyToOne
	@JoinColumn(name = "typeId")
	private Type type;
	private BigDecimal amount;
	private String description;
	private String frequency;
	private String parcelsNumber;
	private LocalDate startDate;
	private LocalDate endDate;

	public Long getId() {
		return id;
	}

	public Category getCategoryId() {
		return category;
	}

	public void setCategoryId(Category categoryId) {
		this.category = categoryId;
	}

	public Type getTypeId() {
		return type;
	}

	public void setTypeId(Type typeId) {
		this.type = typeId;
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