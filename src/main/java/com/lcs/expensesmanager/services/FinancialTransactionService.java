package com.lcs.expensesmanager.services;

import com.lcs.expensesmanager.forms.FinancialTransactionForm;
import com.lcs.expensesmanager.models.FinancialTransaction;
import com.lcs.expensesmanager.repositories.FinancialTransactionRepository;
import com.lcs.expensesmanager.utils.DateUtils;
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

    @Autowired
    private DateUtils dateUtils;

    @Transactional(readOnly = true)
    public FinancialTransaction findById(Long id) {
        return financialTransactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transação não encontrado para o id: " + id));
    }

    @Transactional(readOnly = true)
    public List<FinancialTransaction> findAll() {
        return financialTransactionRepository.findAll();
    }

    @Transactional
    public FinancialTransaction create(FinancialTransactionForm form) {
        FinancialTransaction financialTransaction = new FinancialTransaction(form);

        return financialTransactionRepository.save(financialTransaction);
    }

    @Transactional
    public FinancialTransaction update(Long id, FinancialTransactionForm form) {
        dateUtils.checkIfStartDateIsBeforeEndDate(form.getStartDate(), form.getEndDate());

        FinancialTransaction existingTransaction = findById(id);

        existingTransaction.setCategory(form.getCategory());
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
