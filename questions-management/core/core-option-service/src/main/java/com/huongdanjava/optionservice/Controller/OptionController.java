package com.huongdanjava.optionservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huongdanjava.optionservice.document.Option;
import com.huongdanjava.optionservice.repository.OptionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/option")
public class OptionController {

    @Autowired
    OptionRepository optionRepository;

    @PostMapping("/all")
    public Mono<Option> createOption(@RequestBody Option option) {
        return optionRepository.save(option);
    }

    // get all option by question Id
    @GetMapping("")
    public Flux<Option> findByQuestionyId(@RequestParam String questionId) {
        return optionRepository.findByQuestionId(questionId);
    }

    @GetMapping("/all")
    public Flux<Option> getOption() {
        return optionRepository.findAll();
    }
}
