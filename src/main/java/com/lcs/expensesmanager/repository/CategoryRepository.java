package com.lcs.expensesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcs.expensesmanager.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
