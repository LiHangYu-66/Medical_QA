package com.example.medical_qa.dao;

import com.example.medical_qa.entity.Disease;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends Neo4jRepository<Disease, Long> {
    // 根据疾病名称查询疾病的症状
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.symptoms")
    List<String> findSymptomByName(@Param("name") String name);

    // 根据疾病名称查询疾病的常用药品
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.drugs")
    List<String> findDrugByName(@Param("name") String name);

    // 根据疾病名称查询疾病的推荐食物
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.recommendedFoods")
    List<String> findRecommendedFoodByName(@Param("name") String name);

    // 根据疾病名称查询疾病的忌口食物
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.avoidedFoods")
    List<String> findAvoidedFoodByName(@Param("name") String name);

    // 根据疾病名称查询疾病的检查项目
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.checks")
    List<String> findCheckByName(@Param("name") String name);


    // 根据疾病名称查询疾病的所属科室
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.department")
    List<String> findDepartmentByName(@Param("name") String name);

    // 根据疾病名称查询疾病的病因
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.cause")
    List<String> findCauseByName(@Param("name") String name);

    // 根据疾病名称查询疾病的防御措施
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.prevent")
    List<String> findPreventByName(@Param("name") String name);

    // 根据疾病名称查询疾病的持续时间
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.cureLastTime")
    List<String> findCureLastTimeByName(@Param("name") String name);

    // 根据疾病名称查询疾病的治愈概率
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.curedProb")
    List<String> findCuredProbByName(@Param("name") String name);

    // 根据疾病名称查询疾病的治疗方式
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.cureWay")
    List<String> findCureWayByName(@Param("name") String name);

    // 根据疾病名称查询疾病的易感人群
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.easyGet")
    List<String> findEasyGetByName(@Param("name") String name);

    // 根据疾病名称查询疾病的描述
    @Query("MATCH (d:Disease) WHERE d.name = $name RETURN d.desc")
    List<String> findDescByName(@Param("name") String name);

}
