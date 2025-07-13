package com.lcs.finsight.services;

import com.lcs.finsight.dtos.request.FinancialTransactionRequestDto;
import com.lcs.finsight.exceptions.FinancialTransactionExceptions;
import com.lcs.finsight.models.FinancialTransaction;
import com.lcs.finsight.models.FinancialTransactionCategory;
import com.lcs.finsight.repositories.FinancialTransactionRepository;
import com.lcs.finsight.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FinancialTransactionService {

    private final FinancialTransactionRepository financialTransactionRepository;
    private final FinancialTransactionCategoryService financialTransactionCategoryService;
    private final DateUtils dateUtils;

    public FinancialTransactionService(
            FinancialTransactionRepository financialTransactionRepository,
            FinancialTransactionCategoryService financialTransactionCategoryService,
            DateUtils dateUtils
    ) {
        this.financialTransactionRepository = financialTransactionRepository;
        this.financialTransactionCategoryService = financialTransactionCategoryService;
        this.dateUtils = dateUtils;
    }

    @Transactional(readOnly = true)
    public FinancialTransaction findById(Long id) {
        return financialTransactionRepository.findById(id)
                .orElseThrow(() -> new FinancialTransactionExceptions.FinancialTransactionNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<FinancialTransaction> findAll() {
        return financialTransactionRepository.findAll();
    }

    @Transactional
    public FinancialTransaction create(FinancialTransactionRequestDto dto) {
        FinancialTransactionCategory category = financialTransactionCategoryService.findById(dto.getCategoryId());

        FinancialTransaction financialTransaction = new FinancialTransaction();

        financialTransaction.setCategory(category);
        financialTransaction.setType(dto.getType());
        financialTransaction.setAmount(dto.getAmount());
        financialTransaction.setDescription(dto.getDescription());
        financialTransaction.setFrequency(dto.getFrequency());
        financialTransaction.setParcelsNumber(dto.getParcelsNumber());
        financialTransaction.setStartDate(dto.getStartDate());
        financialTransaction.setEndDate(dto.getEndDate());

        return financialTransactionRepository.save(financialTransaction);
    }

    @Transactional
    public FinancialTransaction update(Long id, FinancialTransactionRequestDto dto) {
        dateUtils.checkIfStartDateIsBeforeEndDate(dto.getStartDate(), dto.getEndDate());

        FinancialTransaction existingTransaction = findById(id);
        FinancialTransactionCategory category = financialTransactionCategoryService.findById(dto.getCategoryId());

        existingTransaction.setCategory(category);
        existingTransaction.setType(dto.getType());
        existingTransaction.setAmount(dto.getAmount());
        existingTransaction.setDescription(dto.getDescription());
        existingTransaction.setFrequency(dto.getFrequency());
        existingTransaction.setParcelsNumber(dto.getParcelsNumber());
        existingTransaction.setStartDate(dto.getStartDate());
        existingTransaction.setEndDate(dto.getEndDate());

        return financialTransactionRepository.save(existingTransaction);
    }

    @Transactional
    public void delete(Long id) {
        financialTransactionRepository.deleteById(id);
    }
}
