package com.example.medical_qa.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextFileReaderTest {

    @Test
    void testReadTextFile() {
        TextFileReader textFileReader = new TextFileReader();

        // ���Դ��ڵ��ļ�
        String filePath = "E:/Medical_QA/src/main/resources/data/check.txt";
        List<String> content = textFileReader.readTextFile(filePath);
        Assertions.assertFalse(content.isEmpty(), "�ļ����ݲ�ӦΪ��");
        System.out.println(content);
    }
}
