package com.huongdanjava.categoryservice.document;

import lombok.Data;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="Category")
public class Category {

    @Id
    private String id;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;
}
