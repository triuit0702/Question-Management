package com.huongdanjava.categoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huongdanjava.categoryservice.dto.Category;
import com.huongdanjava.categoryservice.service.CoreCategoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CoreCategoryService coreCategoryService;

    @PostMapping("/add")
    public Mono<Category> createCategory(@RequestBody Category category) {
        return coreCategoryService.save(category);
    }

    @GetMapping("/all")
    public Flux<Category> getCategory() {
        return coreCategoryService.findAll();
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Category>> updateCategory(@PathVariable(value = "id") String categoryId, @RequestBody Category category) {
        return coreCategoryService.updateCategory(categoryId, category).map(updateCategory -> ResponseEntity.ok(updateCategory))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCategory(@PathVariable(value = "id") String categoryId) {
        return coreCategoryService.deleteCategory(categoryId).map(statusCode -> new ResponseEntity<Void>(statusCode));
    }
}
