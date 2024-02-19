package com.example.medical_qa.dao;

import com.example.medical_qa.entity.Disease;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface Symptom extends Neo4jRepository<Symptom, Long> {

    // 根据疾病名称查询疾病
    @Query("MATCH (s:Symptom)-[:HAS_SYMPTOM]->(d:Disease) WHERE s.name = $name RETURN d")
    List<Disease> findDiseaseBySymptomName(String name);
}
