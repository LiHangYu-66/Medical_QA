package com.example.medical_qa.dao;

import com.example.medical_qa.entity.Drug;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrugRepository extends Neo4jRepository<Drug, Long> {

    // 根据药物名称查询疾病
    @Query("MATCH (m:Drug)-[r:COMMON_DRUG]->(n:Disease) WHERE m.name = $name RETURN m.name, r.name, n.name " +
            "UNION ALL " +
            "MATCH (m:Drug)-[r:RECOMMEND_DRUG]->(n:Disease) WHERE m.name = $name RETURN m.name, r.name, n.name")
    List<String> findDiseaseByName(@Param("name") String name);

    // 根据药物名称查询生产厂商
    @Query("MATCH (m:Drug)-[r:PRODUCED_BY]->(n:Producer) WHERE m.name = $name RETURN m.name, r.name, n.name ")
    List<String> findProducerByName(@Param("name") String name);

}
