package com.huongdanjava.questionservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.CoreQuestionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @Override
    public Mono<Question> findQuestionById(String id) {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        
        WebClient.ResponseSpec responseSpec = client.get().uri("/question/" + id).retrieve();
        return responseSpec.bodyToMono(Question.class);
    }

    @Override
    public Mono<Question> addNewQuestion(Question question) {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        WebClient.ResponseSpec responseSpec = client.post().uri("/question/all").body(BodyInserters.fromObject(question)).retrieve();
        return responseSpec.bodyToMono(Question.class);
    }



    
}
