package com.example.medical_qa.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class MedicalQaController {
    // 使用@RequestMapping注解，定义了一个API端点
    @RequestMapping("/api")
    // 使用@ResponseBody注解，表示该方法的返回结果直接写入 HTTP 响应体中
    @ResponseBody
    public String apiEndpoint(){
        // TODO: 实现处理请求并返回响应的逻辑
        return "Response";
    }
}