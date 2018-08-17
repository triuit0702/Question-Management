package com.huongdanjava.questionservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompositeQuestion {

    private String id;

    private String description;

    private Category category;

    private List<Option> options;
}
