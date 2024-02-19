package com.example.medical_qa.service;

import java.util.List;
import java.util.Map;

public interface MedicalDatabaseService {
    String retrieveInformation(List<Map<String, Object>> cyphers);
}
