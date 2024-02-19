package com.example.medical_qa.dao;

import com.example.medical_qa.entity.Drug;
import com.example.medical_qa.entity.Producer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface ProducerRepository extends Neo4jRepository<Producer, Long>{

    // 根据厂商名称查询药品
    @Query("MATCH (p:Producer)-[:PRODUCES]->(d:Drug) WHERE p.name = $name RETURN d")
    List<Drug> findDrugsByProducerName(String name);
}
