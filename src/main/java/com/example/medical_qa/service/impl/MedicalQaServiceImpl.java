package com.example.medical_qa.service.impl;

import com.example.medical_qa.service.MedicalDatabaseService;
import com.example.medical_qa.service.MedicalQaService;
import com.example.medical_qa.service.QuestionClassifier;
import com.example.medical_qa.service.QuestionPaser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * MedicalQaServiceImpl 类是医疗问答服务的实现，用于处理用户的医疗问题。
 */
@Service
public class MedicalQaServiceImpl implements MedicalQaService {
    String answer = "对不起，我无法理解您的问题。";

    @Autowired
    private QuestionClassifier questionClassifier;

    @Autowired
    private QuestionPaser questionPaser;

    @Autowired
    private MedicalDatabaseService medicalDatabaseService;

    /**
     * 处理用户提出的医疗问题。
     *
     * @param question 用户提出的医疗问题。
     * @return 根据问题分析得到的意图，从医疗数据库中检索相关信息的答案。
     */
    @Override
    public String processMedicalQuestion(String question) {
        // 分析用户问题，获取用户提问的主题
        Map<String, Object> intent = questionClassifier.classify(question);

        if (intent == null || intent.isEmpty()) {
            // 无法识别用户提问的主题
            return answer;
        }
        // 解析用户问题，获取问题cypher查询语句
        List<Map<String, Object>> cyphers = questionPaser.paser(intent);

        // 套模板，根据意图去数据库中查找答案
        return medicalDatabaseService.retrieveInformation(cyphers);
    }
}



