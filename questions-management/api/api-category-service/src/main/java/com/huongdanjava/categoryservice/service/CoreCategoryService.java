package com.huongdanjava.categoryservice.service;

import com.huongdanjava.categoryservice.dto.Category;

import reactor.core.publisher.Mono;

public interface CoreCategoryService {

    String getServiceUrl();
    Mono<Category> save(Category category);
}
