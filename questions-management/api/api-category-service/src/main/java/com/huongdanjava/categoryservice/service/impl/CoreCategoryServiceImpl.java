package com.huongdanjava.categoryservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.huongdanjava.categoryservice.dto.Category;
import com.huongdanjava.categoryservice.service.CoreCategoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoreCategoryServiceImpl implements CoreCategoryService {

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

    @Override
    public Flux<Category> findAll() {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        WebClient.ResponseSpec responseSpec = client.get().uri("/category/all").retrieve();
        return responseSpec.bodyToFlux(Category.class);
    }

    @Override
    public Mono<Category> updateCategory(String categoryId, Category category) {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        WebClient.ResponseSpec responseSpec = client.put().uri("/category/" + categoryId).body(BodyInserters.fromObject(category)).retrieve();
        return responseSpec.bodyToMono(Category.class);
    }

    @Override
    public Mono<HttpStatus> deleteCategory(String categoryId) {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();

        return client.delete().uri("/category/" + categoryId).exchange().map(response -> response.statusCode());
    }

}
