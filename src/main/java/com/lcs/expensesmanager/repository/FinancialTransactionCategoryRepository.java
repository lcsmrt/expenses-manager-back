package com.lcs.expensesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcs.expensesmanager.model.FinancialTransactionCategory;

@Repository
public interface FinancialTransactionCategoryRepository extends JpaRepository<FinancialTransactionCategory, Long> {
}
