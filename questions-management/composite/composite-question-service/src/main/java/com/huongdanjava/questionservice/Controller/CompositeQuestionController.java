package com.huongdanjava.questionservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huongdanjava.questionservice.dto.CompositeQuestion;
import com.huongdanjava.questionservice.dto.Question;
import com.huongdanjava.questionservice.service.CompositeQuestionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/question")
public class CompositeQuestionController {

    @Autowired
    private CompositeQuestionService compositeQuestionService;

    @GetMapping("/all")
    public Flux<CompositeQuestion> findAllQuestions() {
        return compositeQuestionService.findAllQuestions();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CompositeQuestion>> findQuestionById(@PathVariable(value = "id") String questionId) {
        return compositeQuestionService.findQuestionById(questionId).map(compositeQuestion -> ResponseEntity.ok(compositeQuestion))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/all")
    public Mono<ResponseEntity<CompositeQuestion>> addNewQuestion(@RequestBody Question question) {
        return compositeQuestionService.addNewQuestion(question).map(compositeQuestion -> ResponseEntity.ok(compositeQuestion))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
