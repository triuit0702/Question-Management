package com.huongdanjava.questionservice.dto;

import lombok.Data;

@Data
public class Option {

    private String id;
    private String description;
    private String note;
    private Boolean isCorrect;
    private String questionId;
}
