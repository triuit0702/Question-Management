package com.huongdanjava.questionservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.huongdanjava.questionservice.dto.Category;
import com.huongdanjava.questionservice.service.CoreCategoryService;

import reactor.core.publisher.Mono;

@Service
public class CoreCategoryServiceImpl implements CoreCategoryService{

    @Value("${corecategoryservice.url}")
    private String coreCategoryServiceUrl;

    @Override
    public String getServiceUrl() {
        // TODO Auto-generated method stub
        return coreCategoryServiceUrl;
    }

    @Override
    public Mono<Category> findById(String categoryId) {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        
        WebClient.ResponseSpec responseSpec = client.get().uri("/category/" + categoryId).retrieve();
        System.out.println(responseSpec.bodyToMono(Category.class).toString());
        return responseSpec.bodyToMono(Category.class);
    }

}
