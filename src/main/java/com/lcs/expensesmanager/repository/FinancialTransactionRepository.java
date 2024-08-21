package com.lcs.expensesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcs.expensesmanager.model.FinancialTransaction;

@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long> {}
