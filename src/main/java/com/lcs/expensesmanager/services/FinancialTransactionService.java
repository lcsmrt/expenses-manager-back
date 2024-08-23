package com.lcs.expensesmanager.services;

import com.lcs.expensesmanager.forms.FinancialTransactionForm;
import com.lcs.expensesmanager.model.FinancialTransaction;
import com.lcs.expensesmanager.model.FinancialTransactionCategory;
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

    @Autowired
    private FinancialTransactionCategoryService categoryService;

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
        FinancialTransactionCategory category = categoryService.findById(form.getCategoryId());
        FinancialTransaction financialTransaction = new FinancialTransaction(form, category);
        return financialTransactionRepository.save(financialTransaction);
    }

    @Transactional
    public FinancialTransaction update(FinancialTransactionForm form, Long id) {
        FinancialTransaction existingTransaction = findById(id);
        FinancialTransactionCategory category = categoryService.findById(form.getCategoryId());

        existingTransaction.setCategory(category);
        existingTransaction.setType(form.getType());
        existingTransaction.setAmount(form.getAmount());
        existingTransaction.setDescription(form.getDescription());
        existingTransaction.setFrequency(form.getFrequency());
        existingTransaction.setParcelsNumber(form.getParcelsNumber());
        existingTransaction.setStartDate(form.getStartDate());
        existingTransaction.setEndDate(form.getEndDate());

        return financialTransactionRepository.save(existingTransaction);
    }

    @Transactional
    public void delete(Long id) {
        financialTransactionRepository.deleteById(id);
    }
}
