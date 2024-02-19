package com.example.medical_qa.service.impl;

import com.example.medical_qa.service.QuestionPaser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionPaserImpl implements QuestionPaser {
    @Override
    public List<Map<String, Object>> paser(Map<String, Object> intent) {
        // 医疗特征词
        Map<String, List<String>> args = (Map<String, List<String>>) intent.get("args");
        Map<String, List<String>> entityDict = buildEntityDict(args);
        List<String> questionTypes = (List<String>) intent.get("question_types");
        Map<String, Object> cypherMap = new HashMap<>();
        List<Map<String, Object>> cyphers = new ArrayList<>();

        for (String questionType : questionTypes) {
            List<String> cypher = new ArrayList<>();
            cypherMap.put("questionType", questionType);
            if (questionType == "DiseaseSymptom") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "SymptomDisease") {
                cypher = buildCypher(questionType, entityDict.get("Symptom"));
            }else if (questionType == "DiseaseAccompany") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseNotFood") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseFood") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseDrug") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DrugDisease") {
                cypher = buildCypher(questionType, entityDict.get("Drug"));
            }else if (questionType == "DiseaseCheck") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseBelong") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseCause") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseasePrevent") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseLasttime") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseCureprob") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseCureway") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseEasyget") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }else if (questionType == "DiseaseDesc") {
                cypher = buildCypher(questionType, entityDict.get("Disease"));
            }

            if (cypher != null && !cypher.isEmpty()) {
                cypherMap.put("cypher", cypher);
            }
            cyphers.add((Map<String, Object>) cypher);
        }
        return cyphers;
    }


    public List<String> buildCypher(String questionType, List<String> entities) {
        List<String> cypher = new ArrayList<>();

        // 如果实体列表为空，直接返回空列表
        if (entities == null || entities.isEmpty()) {
            return cypher;
        }

        // 遍历每个实体，根据问题类型生成相应的 SQL 查询
        for (String entity : entities) {
            switch (questionType) {
                // 查询疾病的原因
                case "DiseaseCause":
                    cypher.add("MATCH (m:Disease) WHERE m.name = '" + entity + "' RETURN m.name, m.cause");
                    break;
                // 查询疾病的防御措施
                case "DiseasePrevent":
                    cypher.add("MATCH (m:Disease) WHERE m.name = '" + entity + "' RETURN m.name, m.prevent");
                    break;
                // 查询疾病的持续时间
                case "DiseaseLasttime":
                    cypher.add("MATCH (m:Disease) WHERE m.name = '" + entity + "' RETURN m.name, m.cure_lasttime");
                    break;
                // 查询疾病的治愈概率
                case "DiseaseCureprob":
                    cypher.add("MATCH (m:Disease) WHERE m.name = '" + entity + "' RETURN m.name, m.cured_prob");
                    break;
                // 查询疾病的治疗方式
                case "DiseaseCureway":
                    cypher.add("MATCH (m:Disease) WHERE m.name = '" + entity + "' RETURN m.name, m.cure_way");
                    break;
                // 查询疾病的易发人群
                case "DiseaseEasyget":
                    cypher.add("MATCH (m:Disease) WHERE m.name = '" + entity + "' RETURN m.name, m.easy_get");
                    break;
                // 查询疾病的相关介绍
                case "DiseaseDesc":
                    cypher.add("MATCH (m:Disease) WHERE m.name = '" + entity + "' RETURN m.name, m.desc");
                    break;
                // 查询疾病有哪些症状
                case "DiseaseSymptom":
                    cypher.add("MATCH (m:Disease)-[r:has_symptom]->(n:Symptom) WHERE m.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    break;
                // 查询症状属于哪些疾病
                case "SymptomDisease":
                    cypher.add("MATCH (m:Disease)-[r:has_symptom]->(n:Symptom) WHERE n.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    break;
                // 查询疾病的并发症
                case "DiseaseAccompany":
                    cypher.add("MATCH (m:Disease)-[r:acompany_with]->(n:Disease) WHERE m.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    cypher.add("MATCH (m:Disease)-[r:acompany_with]->(n:Disease) WHERE n.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    break;
                // 查询疾病的忌口
                case "DiseaseNotFood":
                    cypher.add("MATCH (m:Disease)-[r:no_eat]->(n:Food) WHERE m.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    break;
                // 查询疾病建议吃的东西
                case "DiseaseFood":
                    cypher.add("MATCH (m:Disease)-[r:do_eat]->(n:Food) WHERE m.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    cypher.add("MATCH (m:Disease)-[r:recommand_eat]->(n:Food) WHERE m.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    break;
//                // 已知忌口查疾病
//                case "food_not_disease":
//                    cypher.add("MATCH (m:Disease)-[r:no_eat]->(n:Food) WHERE n.name = '" + entity + "' RETURN m.name, r.name, n.name");
//                    break;
//                // 已知推荐查疾病
//                case "food_do_disease":
//                    cypher.add("MATCH (m:Disease)-[r:do_eat]->(n:Food) WHERE n.name = '" + entity + "' RETURN m.name, r.name, n.name");
//                    cypher.add("MATCH (m:Disease)-[r:recommand_eat]->(n:Food) WHERE n.name = '" + entity + "' RETURN m.name, r.name, n.name");
//                    break;
                // 查询疾病常用药品－药品别名记得扩充
                case "DiseaseDrug":
                    cypher.add("MATCH (m:Disease)-[r:common_drug]->(n:Drug) WHERE m.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    cypher.add("MATCH (m:Disease)-[r:recommand_drug]->(n:Drug) WHERE m.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    break;
                // 已知药品查询能够治疗的疾病
                case "DrugDisease":
                    cypher.add("MATCH (m:Disease)-[r:common_drug]->(n:Drug) WHERE n.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    cypher.add("MATCH (m:Disease)-[r:recommand_drug]->(n:Drug) WHERE n.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    break;
                // 查询疾病应该进行的检查
                case "DiseaseCheck":
                    cypher.add("MATCH (m:Disease)-[r:need_check]->(n:Check) WHERE m.name = '" + entity + "' RETURN m.name, r.name, n.name");
                    break;
//                // 已知检查查询疾病
//                case "check_disease":
//                    cypher.add("MATCH (m:Disease)-[r:need_check]->(n:Check) WHERE n.name = '" + entity + "' RETURN m.name, r.name, n.name");
//                    break;
                case "DiseaseBelong":
                    cypher.add("MATCH (m:Disease)-[r:belongs_to]->(n:Department) WHERE m.name = '" + entity + "' RETURN m.name, r.name, n.name");
            }
        }

        return cypher;
    }


    public Map<String, List<String>> buildEntityDict(Map<String, List<String>> args) {
        Map<String, List<String>> entityDict = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : args.entrySet()) {
            String arg = entry.getKey();
            List<String> types = entry.getValue();
            for (String type : types) {
                if (!entityDict.containsKey(arg)) {
                    entityDict.put(type, new ArrayList<>());
                } else {
                    entityDict.get(type).add(arg);
                }
            }
        }
        return entityDict;
    }
}
