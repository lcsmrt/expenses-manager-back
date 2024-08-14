package com.lcs.expensesmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lcs.expensesmanager.forms.CategoryForm;
import com.lcs.expensesmanager.model.Category;
import com.lcs.expensesmanager.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public Category findById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada para o id: " + id));
	}

	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Transactional
	public Category save(CategoryForm form) {
		Category category = new Category(form);
		return categoryRepository.save(category);
	}

	@Transactional
	public Category update(CategoryForm form, Long id) {
		Category existingCategory = findById(id);
		Category updatedCategory = form.update(existingCategory);
		return categoryRepository.save(updatedCategory);
	}

	@Transactional
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
}
