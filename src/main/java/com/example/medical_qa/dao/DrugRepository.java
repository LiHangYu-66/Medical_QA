package com.example.medical_qa.dao;

import com.example.medical_qa.entity.Drug;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrugRepository extends Neo4jRepository<Drug, Long> {

    // 根据药物名称查询疾病
    @Query("MATCH (d:Drug) WHERE d.name = $name RETURN d.treatsDiseases")
    List<String> findDiseaseByName(@Param("name") String name);

    // 根据药物名称查询生产厂商
    @Query("MATCH (d:Drug) WHERE d.name = $name RETURN d.producer")
    List<String> findProducerByName(@Param("name") String name);

}
