package com.example.medical_qa.dto;

import lombok.Data;

@Data
public class MedicalQuestionRequest {
    private String userId;
    private String question;
}

