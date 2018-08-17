package com.huongdanjava.questionservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.huongdanjava.questionservice.dto.CompositeQuestion;
import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.CompositeQuestionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompositeQuestionServiceImpl implements CompositeQuestionService {

    @Value("${compositequestionservice.url}")
    private String compositeQuestionServiceUrl;

    @Override
    public String getServiceUrl() {
        return compositeQuestionServiceUrl;
    }

    @Override
    public Flux<CompositeQuestion> findAllQuestions() {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        WebClient.ResponseSpec responseSpec = client.get().uri("/question/all").retrieve();
        return responseSpec.bodyToFlux(CompositeQuestion.class);
    }

    @Override
    public Mono<CompositeQuestion> findQuestionById(String id) {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        WebClient.ResponseSpec responseSpec = client.get().uri("/question/" + id).retrieve();
        return responseSpec.bodyToMono(CompositeQuestion.class);
    }

    @Override
    public Mono<CompositeQuestion> createNewQuestion(Question question) {
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        WebClient.ResponseSpec responseSpec = client.post().uri("/question/add").body(BodyInserters.fromObject(question)).retrieve();
        return responseSpec.bodyToMono(CompositeQuestion.class);
    }

}
