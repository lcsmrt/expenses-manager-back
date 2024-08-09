package com.lcs.expensesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcs.expensesmanager.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
