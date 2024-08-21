package com.lcs.expensesmanager.services;

import com.lcs.expensesmanager.forms.FinancialTransactionForm;
import com.lcs.expensesmanager.model.FinancialTransaction;
import com.lcs.expensesmanager.repository.FinancialTransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FinancialTransactionService {

    @Autowired
    private FinancialTransactionRepository financialTransactionRepository;

    @Transactional(readOnly = true)
    public FinancialTransaction findById(Long id) {
        return financialTransactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item não encontrado para o id: " + id));
    }

    @Transactional(readOnly = true)
    public List<FinancialTransaction> findAll() {
        return financialTransactionRepository.findAll();
    }

    @Transactional
    public FinancialTransaction save(FinancialTransactionForm form) {
        FinancialTransaction financialTransaction = new FinancialTransaction(form);
    }
}
