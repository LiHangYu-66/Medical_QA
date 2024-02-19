package com.example.medical_qa.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
public class Department {
    @Id
    private Long id;

    private String name;

}

