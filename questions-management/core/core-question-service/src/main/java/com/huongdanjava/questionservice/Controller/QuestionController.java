package com.huongdanjava.questionservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huongdanjava.questionservice.document.Question;
import com.huongdanjava.questionservice.repository.QuestionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/all")
    public Mono<Question> createQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @GetMapping("/all")
    public Flux<Question> getQuestion() {
        return questionRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteQuestion(@PathVariable(value = "id") String questionId) {
        return questionRepository.findById(questionId)
                .flatMap(excistingQuestion -> questionRepository.delete(excistingQuestion).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    // PUT condition: contentype application/json
    @PutMapping("/{id}")
    public Mono<ResponseEntity<Question>> updateQuestion(@PathVariable(value = "id") String questionId, @RequestBody Question question) {
        return questionRepository.findById(questionId).flatMap(excistingQuestion -> {
            excistingQuestion.setCategoryId(question.getCategoryId());
            excistingQuestion.setDescription(question.getDescription());
            return questionRepository.save(excistingQuestion);
        }).map(updateQuestion -> new ResponseEntity<>(updateQuestion,HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Question>> getQuestionById(@PathVariable(value = "id") String questionId) {
        return questionRepository.findById(questionId).map(excistingQuestion -> new ResponseEntity<>(excistingQuestion, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
