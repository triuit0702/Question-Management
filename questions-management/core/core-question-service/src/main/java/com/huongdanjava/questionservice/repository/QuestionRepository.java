package com.huongdanjava.questionservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.huongdanjava.questionservice.document.Question;

public interface QuestionRepository extends ReactiveMongoRepository<Question, String>{

}
