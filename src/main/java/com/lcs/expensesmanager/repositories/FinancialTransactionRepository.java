package com.lcs.expensesmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcs.expensesmanager.models.FinancialTransaction;

@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long> {}
