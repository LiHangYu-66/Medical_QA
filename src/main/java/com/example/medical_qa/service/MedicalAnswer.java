package com.example.medical_qa.service;

import java.util.List;
import java.util.Map;

public interface MedicalAnswer {
    List<String> retrieveInformation(List<Map<String, Object>> cyphers);
}
