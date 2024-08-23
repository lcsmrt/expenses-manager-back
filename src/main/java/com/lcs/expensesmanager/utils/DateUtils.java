package com.lcs.expensesmanager.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateUtils {
    public void checkIfStartDateIsBeforeEndDate(LocalDate startDate, LocalDate endDate) {
        boolean isAfter = startDate.isAfter(endDate);

        if(isAfter) {
            throw new IllegalArgumentException("A data inicial não pode ser maior que a data final.");
        }
    }
}
