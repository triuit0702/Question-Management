package com.huongdanjava.questionservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.CoreQuestionService;

import reactor.core.publisher.Flux;

@Service
public class CoreQuestionServiceImpl implements CoreQuestionService {

    @Value("${corequestionservice.url}")
    private String coreQuestionServiceUrl;

    @Override
    public String getServiceUrl() {
        return coreQuestionServiceUrl;
    }

    @Override
    public Flux<Question> findAllQuestions() {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        
        WebClient.ResponseSpec responseSpec = client.get().uri("/question/all").retrieve();
        return responseSpec.bodyToFlux(Question.class);
    }

}
