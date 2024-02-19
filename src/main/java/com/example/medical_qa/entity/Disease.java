package com.example.medical_qa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@Node
public class Disease {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String cause;
    private String prevent;
    private String cureLastTime;
    private String curedProb;
    private String cureWay;
    private String easyGet;
    private String desc;


    @Relationship(type = "HAS_SYMPTOM", direction = Relationship.Direction.OUTGOING)
    private List<Symptom> symptoms;

    @Relationship(type = "COMMON_DRUG", direction = Relationship.Direction.OUTGOING)
    private List<Drug> drugs;

    // 推荐食物
    @Relationship(type = "RECOMMENDED_FOOD", direction = Relationship.Direction.OUTGOING)
    private List<Food> recommendedFoods;

    // 忌口食物
    @Relationship(type = "AVOIDED_FOOD", direction = Relationship.Direction.OUTGOING)
    private List<Food> avoidedFoods;

    @Relationship(type = "NEED_CHECK", direction = Relationship.Direction.OUTGOING)
    private List<Check> checks;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private Department department;

}
