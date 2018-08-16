package com.huongdanjava.optionservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.huongdanjava.optionservice.document.Option;

import reactor.core.publisher.Flux;

public interface OptionRepository extends ReactiveMongoRepository<Option, String>{

    Flux<Option> findByQuestionId(String questionId);
}
