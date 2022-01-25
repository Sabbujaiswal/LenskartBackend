package com.lenskartapp.service;

import com.lenskartapp.model.Category;
import com.lenskartapp.exceptions.CategoryNotFoundException;

import java.util.List;

public interface ICategoryService {

    Category addCategory(Category category);


    void updateCategory(Category category);


    void deleteCategory(int categoryId) throws CategoryNotFoundException;


    Category getById(int categoryId) throws CategoryNotFoundException;


    List<Category> getAll();


}
