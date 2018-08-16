package com.huongdanjava.questionservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.huongdanjava.questionservice.dto.Option;
import com.huongdanjava.questionservice.service.CoreOptionService;

import reactor.core.publisher.Flux;

@Service
public class CoreOptionServiceImpl implements CoreOptionService{

    @Value("${coreoptionservice.url}")
    private String coreOptionServiceUrl;
    
    @Override
    public String getServiceUrl() {
        // TODO Auto-generated method stub
        return coreOptionServiceUrl;
    }

    @Override
    public Flux<Option> getOptions(String questionId) {
        System.out.println("IN - getOptions");
        WebClient client = WebClient.builder().baseUrl(getServiceUrl()).build();
        WebClient.ResponseSpec responseSpec = client.get().uri("/option?questionId=" +questionId).retrieve();
        System.out.println(responseSpec.bodyToFlux(Option.class));
        return responseSpec.bodyToFlux(Option.class);
    }

}
