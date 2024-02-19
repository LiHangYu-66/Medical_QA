package com.example.medical_qa.entity;

import jakarta.persistence.GeneratedValue;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
@Data
public class Drug {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "RECOMMEND_DRUG", direction = Relationship.Direction.OUTGOING)
    private List<Disease> treatsDiseases;

    @Relationship(type = "PRODUCED_BY", direction = Relationship.Direction.INCOMING)
    private Producer producer;

}


