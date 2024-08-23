package com.lcs.expensesmanager.services;

import com.lcs.expensesmanager.forms.FinancialTransactionCategoryForm;
import com.lcs.expensesmanager.model.FinancialTransactionCategory;
import com.lcs.expensesmanager.repository.FinancialTransactionCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FinancialTransactionCategoryService {

    @Autowired
    private FinancialTransactionCategoryRepository financialTransactionCategoryRepository;

    @Transactional(readOnly = true)
    public FinancialTransactionCategory findById(Long id) {
        return financialTransactionCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada para o id: " + id));
    }

    @Transactional(readOnly = true)
    public List<FinancialTransactionCategory> findAll() {
        return financialTransactionCategoryRepository.findAll();
    }

    @Transactional
    public FinancialTransactionCategory save(FinancialTransactionCategoryForm form) {
        FinancialTransactionCategory category = new FinancialTransactionCategory(form);

        return financialTransactionCategoryRepository.save(category);
    }

    @Transactional
    public FinancialTransactionCategory update(FinancialTransactionCategoryForm form, Long id) {
        FinancialTransactionCategory existingCategory = findById(id);

        existingCategory.setDescription(form.getDescription());
        existingCategory.setSpendingLimit(form.getSpendingLimit());

        return financialTransactionCategoryRepository.save(existingCategory);
    }

    @Transactional
    public void delete(Long id) {
        financialTransactionCategoryRepository.deleteById(id);
    }
}
