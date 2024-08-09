package com.lcs.expensesmanager.services;

import com.lcs.expensesmanager.repository.ItemRepository;
import com.lcs.expensesmanager.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;

public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Transactional(readOnly = true)
	public Item findById(Long id) {
		return itemRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Item não encontrado para o id: " + id));
	}
}
