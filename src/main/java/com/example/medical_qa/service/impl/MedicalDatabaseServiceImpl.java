package com.example.medical_qa.service.impl;

import com.example.medical_qa.service.MedicalDatabaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MedicalDatabaseServiceImpl implements MedicalDatabaseService {
    @Override
    public String retrieveInformation(List<Map<String, Object>> cyphers) {
        List<String> finalAnswer = new ArrayList<>();
        for (Map<String,Object> cypher:cyphers){
            String questionType = (String) cypher.get("questionType");
            List<String> cypherList = (List<String>) cypher.get("cypher");
            for (String c:cypherList){
                finalAnswer.add(questionType + " : " + c);
            }
        }
        return null;
    }
}
