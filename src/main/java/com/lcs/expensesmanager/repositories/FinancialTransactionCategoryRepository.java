package com.lcs.expensesmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcs.expensesmanager.models.FinancialTransactionCategory;

@Repository
public interface FinancialTransactionCategoryRepository extends JpaRepository<FinancialTransactionCategory, Long> {
}
