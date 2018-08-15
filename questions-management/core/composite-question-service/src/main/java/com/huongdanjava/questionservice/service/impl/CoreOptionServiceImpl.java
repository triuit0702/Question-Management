package com.huongdanjava.questionservice.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.huongdanjava.questionservice.service.CoreOptionService;

public class CoreOptionServiceImpl implements CoreOptionService{

    @Value("${coreoptionservice.url}")
    private String coreOptionServiceUrl;
    
    @Override
    public String getServiceUrl() {
        // TODO Auto-generated method stub
        return coreOptionServiceUrl;
    }

}
