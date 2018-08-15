package com.huongdanjava.categoryservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.huongdanjava.categoryservice.document.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{

}
