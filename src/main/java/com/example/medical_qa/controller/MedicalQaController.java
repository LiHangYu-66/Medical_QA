//package com.example.medical_qa.controller;
//
//import com.example.medical_qa.dto.MedicalQuestionRequest;
//import com.example.medical_qa.service.ConversationService;
//import com.example.medical_qa.service.MedicalQaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/medical")
//public class MedicalQaController {
//
//    @Autowired
//    private MedicalQaService medicalQaService;
//    @Autowired
//    private ConversationService conversationService;
//
//    @PostMapping("/qa")
//    public ResponseEntity<String> submitMedicalQuestion(@RequestBody MedicalQuestionRequest request) {
//        try {
//            // 委托给服务层处理业务逻辑
//            String answer = medicalQaService.processMedicalQuestion(request.getQuestion());
//
//            //保存对话
//            String userId = request.getUserId();
//            String question = request.getQuestion();
//            conversationService.saveUserQuestion(userId,question,answer);
//
//            return ResponseEntity.ok(answer);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("处理问题时出现错误: " + e.getMessage());
//        }
//    }
//}
//
//
