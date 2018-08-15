package com.huongdanjava.optionservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.huongdanjava.optionservice.document.Option;

public interface OptionRepository extends ReactiveMongoRepository<Option, String>{

}
