package com.huongdanjava.questionservice.service;

import com.huongdanjava.questionservice.dto.Question;

import reactor.core.publisher.Flux;

public interface CoreQuestionService {

    String getServiceUrl();
    Flux<Question> findAllQuestions();
}
