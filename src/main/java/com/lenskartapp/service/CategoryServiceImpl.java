package com.lenskartapp.service;

import com.lenskartapp.exceptions.CategoryNotFoundException;
import com.lenskartapp.model.Category;
import com.lenskartapp.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    ICategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category getById(int categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
