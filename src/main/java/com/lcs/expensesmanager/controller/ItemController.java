package com.lcs.expensesmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcs.expensesmanager.model.Item;
import com.lcs.expensesmanager.repository.ItemRepository;

@RestController
@RequestMapping("/api/expenses-manager/item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@PostMapping
	public Item createItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}

	@GetMapping("/{id}")
	public Item getItem(@PathVariable Long id) {
		return itemRepository.findById(id).orElse(null);
	}

	@GetMapping
	public List<Item> getItems() {
		return (List<Item>) itemRepository.findAll();
	}
}
