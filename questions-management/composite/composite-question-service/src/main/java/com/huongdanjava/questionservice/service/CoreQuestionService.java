package com.huongdanjava.questionservice.service;

import com.huongdanjava.questionservice.dto.Question;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoreQuestionService {

    String getServiceUrl();
    Flux<Question> findAllQuestions();
    Mono<Question> findQuestionById(String id);
    Mono<Question> addNewQuestion(Question question);
}
