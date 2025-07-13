package com.lcs.finsight.services;

import com.lcs.finsight.dtos.request.FinancialTransactionCategoryRequestDto;
import com.lcs.finsight.exceptions.FinancialTransactionCategoryExceptions;
import com.lcs.finsight.models.FinancialTransactionCategory;
import com.lcs.finsight.repositories.FinancialTransactionCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FinancialTransactionCategoryService {

    private final FinancialTransactionCategoryRepository categoryRepository;

    public FinancialTransactionCategoryService(FinancialTransactionCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public FinancialTransactionCategory findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new FinancialTransactionCategoryExceptions.FinancialTransactionCategoryNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<FinancialTransactionCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public FinancialTransactionCategory create(FinancialTransactionCategoryRequestDto dto) {
        FinancialTransactionCategory category = new FinancialTransactionCategory();

        category.setDescription(dto.getDescription());
        category.setSpendingLimit(dto.getSpendingLimit());

        return categoryRepository.save(category);
    }

    @Transactional
    public FinancialTransactionCategory update(Long id, FinancialTransactionCategoryRequestDto dto) {
        FinancialTransactionCategory existingCategory = findById(id);

        existingCategory.setDescription(dto.getDescription());
        existingCategory.setSpendingLimit(dto.getSpendingLimit());

        return categoryRepository.save(existingCategory);
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
