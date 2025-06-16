package com.lcs.finsight.models;

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
