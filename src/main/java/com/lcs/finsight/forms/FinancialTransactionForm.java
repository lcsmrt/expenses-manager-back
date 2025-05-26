package com.lcs.finsight.forms;

import com.lcs.finsight.models.FinancialTransactionCategory;
import com.lcs.finsight.models.FinancialTransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FinancialTransactionForm {

    private FinancialTransactionCategory category;

    @NotNull(message = "O tipo de transação não pode ser nulo.")
    private FinancialTransactionType type;

    @NotNull(message = "A quantidade não pode ser nula.")
    private BigDecimal amount;

    @NotBlank(message = "A descrição não pode ser vazia.")
    private String description;

    private String frequency;
    private Integer parcelsNumber;

    private LocalDate startDate;
    private LocalDate endDate;

    public FinancialTransactionCategory getCategory() {
        return category;
    }

    public FinancialTransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getFrequency() {
        return frequency;
    }

    public Integer getParcelsNumber() {
        return parcelsNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
