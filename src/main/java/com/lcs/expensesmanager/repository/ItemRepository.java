package com.lcs.expensesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcs.expensesmanager.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {}
