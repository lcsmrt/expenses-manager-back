package com.lcs.expensesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcs.expensesmanager.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
