package com.lenskartapp.controllers;

import com.lenskartapp.exceptions.CategoryNotFoundException;
import com.lenskartapp.model.Category;
import com.lenskartapp.model.Frame;
import com.lenskartapp.service.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category-api")
public class CategoryController {
    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    ICategoryService categoryService;

    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    ResponseEntity<Category> addCategory(@RequestBody Category category) {
        logger.debug("inside add category method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding category");
        Category ncategory = categoryService.addCategory(category);
        logger.info(" add category" + ncategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(ncategory);
    }

    @PutMapping("/category")
    ResponseEntity<Void> updateCategory(@RequestBody Category category) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating category");
        categoryService.updateCategory(category);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/category/id/{categoryid}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryid") int categoryId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting category");
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/category")
    ResponseEntity<List<Category>> getAll(Category category) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "All categories");
        List<Category> caterories = categoryService.getAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(caterories);
    }

    @GetMapping("/category/id/{categoryid}")
    public ResponseEntity<Category> getById(@PathVariable("categoryid") int categoryId) {
        logger.debug("inside id");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting category by id");
        Category category = categoryService.getById(categoryId);
        logger.info("got one " + category);
        return ResponseEntity.ok().headers(headers).body(category);
    }


}
