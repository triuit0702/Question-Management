package com.huongdanjava.questionservice.service;

import com.huongdanjava.questionservice.dto.Category;

import reactor.core.publisher.Mono;

public interface CoreCategoryService {

    String getServiceUrl();
    
    Mono<Category> findById(String categoryId);
}
