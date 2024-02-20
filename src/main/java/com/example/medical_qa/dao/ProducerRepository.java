package com.example.medical_qa.dao;

import com.example.medical_qa.entity.Producer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface ProducerRepository extends Neo4jRepository<Producer, Long>{

    // 根据厂商名称查询药品
    @Query("MATCH (m:Producer)-[r:PRODUCED_BY]->(n:Drug) WHERE m.name = $name RETURN m.name, r.name, n.name ")
    List<String> findDrugsByProducerName(String name);
}
