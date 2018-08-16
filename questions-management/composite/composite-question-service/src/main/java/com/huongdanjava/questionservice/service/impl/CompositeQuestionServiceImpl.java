package com.huongdanjava.questionservice.service.impl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huongdanjava.questionservice.dto.CompositeQuestion;
import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.CompositeQuestionService;
import com.huongdanjava.questionservice.service.CoreCategoryService;
import com.huongdanjava.questionservice.service.CoreOptionService;
import com.huongdanjava.questionservice.service.CoreQuestionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class CompositeQuestionServiceImpl implements CompositeQuestionService {

    @Autowired
    private CoreQuestionService coreQuestionService;

    @Autowired
    private CoreOptionService coreOptionService;

    @Autowired
    private CoreCategoryService coreCategoryService;

    @Override
    public Flux<CompositeQuestion> findAllQuestions() {
        Flux<Question> questionsFromCoreQuestionService = coreQuestionService.findAllQuestions();

        return questionsFromCoreQuestionService
                .flatMap(question -> coreCategoryService.findById(question.getCategoryId())
                        .flatMap(category -> coreOptionService.getOptions(question.getId()).collectList()
                                .map(options -> new CompositeQuestion(question.getId(), question.getDescription(), category, options))))
                .subscribeOn(Schedulers.elastic());
    }

    @Override
    public Mono<CompositeQuestion> findQuestionById(String id) {
        Mono<Question> questionsFromCoreQuestionService = coreQuestionService.findQuestionById(id);

        return questionsFromCoreQuestionService
                .flatMap(question -> coreCategoryService.findById(question.getCategoryId())
                        .flatMap(category -> coreOptionService.getOptions(question.getId()).collectList()
                                .map(options -> new CompositeQuestion(question.getId(), question.getDescription(), category, options))))
                .subscribeOn(Schedulers.elastic());
    }

    @Override
    public Mono<CompositeQuestion> addNewQuestion(Question question) {
        return coreCategoryService.findById(question.getCategoryId())
                .flatMap(category -> coreQuestionService.addNewQuestion(question)
                        .map(newQuestion -> new CompositeQuestion(newQuestion.getId(), newQuestion.getDescription(), category, Collections.emptyList())))
                .subscribeOn(Schedulers.elastic());
    }

}
