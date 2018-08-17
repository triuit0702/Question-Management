package com.huongdanjava.questionservice.service;

import com.huongdanjava.questionservice.dto.CompositeQuestion;
import com.huongdanjava.questionservice.dto.Question;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompositeQuestionService {

    String getServiceUrl();
    Flux<CompositeQuestion> findAllQuestions();
    Mono<CompositeQuestion> findQuestionById(String id);
    Mono<CompositeQuestion> createNewQuestion(Question question);
}
