package com.lcs.expensesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcs.expensesmanager.model.Item;
import com.lcs.expensesmanager.services.ItemService;

@RestController
@RequestMapping("/api/expenses-manager/item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@GetMapping("/{id}")
	public Item getItem(@PathVariable Long id) {
		return itemService.findById(id);
	}
}
