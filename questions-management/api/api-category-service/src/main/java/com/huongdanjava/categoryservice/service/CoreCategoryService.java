package com.huongdanjava.categoryservice.service;



import org.springframework.http.HttpStatus;

import com.huongdanjava.categoryservice.dto.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoreCategoryService {

    String getServiceUrl();
    Mono<Category> save(Category category);
    Flux<Category> findAll();
    Mono<Category> updateCategory(String categoryId, Category category);
    Mono<HttpStatus> deleteCategory(String categoryId);
}
