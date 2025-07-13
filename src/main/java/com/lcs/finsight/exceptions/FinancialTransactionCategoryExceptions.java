package com.lcs.finsight.exceptions;

public class FinancialTransactionCategoryExceptions {
    public static class FinancialTransactionCategoryNotFoundException extends RuntimeException {
        public FinancialTransactionCategoryNotFoundException(Long id) {
            super("Categoria não encontrada para o id " + id + " .");
        }
    }
}
