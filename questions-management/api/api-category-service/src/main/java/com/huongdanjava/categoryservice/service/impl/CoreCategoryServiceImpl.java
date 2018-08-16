package com.huongdanjava.categoryservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.huongdanjava.categoryservice.dto.Category;
import com.huongdanjava.categoryservice.service.CoreCategoryService;

import reactor.core.publisher.Mono;

public class CoreCategoryServiceImpl implements CoreCategoryService{

    @Value("${corecategoryservice.url}")
    private String coreCategoryServiceUrl;
    
    @Override
    public String getServiceUrl() {
        // TODO Auto-generated method stub
        return coreCategoryServiceUrl;
    }

    @Override
    public Mono<Category> save(Category category) {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        WebClient.ResponseSpec responseSpec = client.post().uri("/category/add").body(BodyInserters.fromObject(category)).retrieve();
        return responseSpec.bodyToMono(Category.class);
    }

}
