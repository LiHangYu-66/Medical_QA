package com.example.medical_qa.service;

import java.util.Map;

public interface QuestionClassifier {
    Map<String, Object> classify(String question);
}
