package com.example.medical_qa.service;

import java.util.List;
import java.util.Map;

public interface QuestionPaser {
    List<Map<String, Object>> paser(Map<String, Object> intent);
}
