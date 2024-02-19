package com.example.medical_qa.exceptions;

public class MedicalException extends RuntimeException {

    public MedicalException(String message) {
        super(message);
    }

    public MedicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
