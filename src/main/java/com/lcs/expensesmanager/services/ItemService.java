package com.lcs.expensesmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lcs.expensesmanager.model.Item;
import com.lcs.expensesmanager.repository.ItemRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Transactional(readOnly = true)
	public Item findById(Long id) {
		return itemRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Item não encontrado para o id: " + id));
	}
}
