package com.lcs.finsight.services;

import com.lcs.finsight.forms.FinancialTransactionCategoryForm;
import com.lcs.finsight.models.FinancialTransactionCategory;
import com.lcs.finsight.repositories.FinancialTransactionCategoryRepository;
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
    public FinancialTransactionCategory create(FinancialTransactionCategoryForm form) {
        FinancialTransactionCategory category = new FinancialTransactionCategory(form);

        return financialTransactionCategoryRepository.save(category);
    }

    @Transactional
    public FinancialTransactionCategory update(Long id, FinancialTransactionCategoryForm form) {
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
