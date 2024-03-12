package com.example.medical_qa.service;

import org.neo4j.driver.Record;
import org.neo4j.driver.*;

public class Neo4jConnectionTest {

    public static void main(String[] args) {
        // Neo4j ������Ϣ
        String uri = "bolt://192.168.10.8:7687";
        String username = "neo4j";
        String password = "Lhyu100218..";

        // ������������
        try (Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password))) {
            // �����Ự
            try (Session session = driver.session()) {
                // ����һ���򵥵Ĳ�ѯ����������
                Result result = session.run("RETURN 1 AS number");
                // �����ѯ���
                while (result.hasNext()) {
                    Record record = result.next();
                    int number = record.get("number").asInt();
                    System.out.println("��ѯ�����" + number);
                }
            }
        } catch (Exception e) {
            // ���������쳣
            System.err.println("���ӵ� Neo4j ���ݿ�ʱ�����쳣��" + e.getMessage());
            e.printStackTrace();
        }
    }
}