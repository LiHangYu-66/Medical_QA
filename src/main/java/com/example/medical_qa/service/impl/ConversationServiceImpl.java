//package com.example.medical_qa.service.impl;
//
//import com.example.medical_qa.dao.ConversationRepository;
//import com.example.medical_qa.entity.ConversationSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class ConversationServiceImpl {
//
//    @Autowired
//    private ConversationRepository conversationRepository;
//
//    private Map<String, ConversationSession> activeSessions = new HashMap<>();
//
//    public void openSession(String userId, String sessionId) {
//        ConversationSession session = new ConversationSession();
//        session.setUserId(userId);
//        session.setSessionId(sessionId);
//        session.setConversationList(new ArrayList<>());
//        activeSessions.put(userId, session);
//    }
//
//    public void closeSession(String userId) {
//        ConversationSession session = activeSessions.remove(userId);
//        if (session != null) {
//            // 将会话保存到 MongoDB
//            conversationRepository.save(session);
//        }
//    }
//
//    public void addConversation(String userId, Conversation conversation) {
//        ConversationSession session = activeSessions.get(userId);
//        if (session != null) {
//            session.getConversationList().add(conversation);
//        }
//    }
//
//    public List<Conversation> getUserConversationHistory(String userId) {
//        // 获取用户的历史对话记录（从 MongoDB 中查询）
//        return conversationRepository.findByUserIdOrderByTimestampAsc(userId);
//    }
//}
//
//
//
