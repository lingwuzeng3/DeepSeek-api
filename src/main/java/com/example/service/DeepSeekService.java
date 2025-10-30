package com.example.service;

/**
 * 包名：com.example.service
 * 用户：admin
 * 日期：2025-10-30
 * 项目名称：Pro-api
 */
import com.example.pojo.DeepSeekRequest;
import com.example.pojo.DeepSeekResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class DeepSeekService {

    private final RestTemplate restTemplate;
    private final String apiKey = "sk-3dac18adb7c840f3a23b74fd45ca57c2";
    private final String apiUrl = "https://api.deepseek.com/chat/completions";

    public DeepSeekService() {
        this.restTemplate = new RestTemplate();
    }

    public String chat(String userMessage) {
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 构建消息
        List<DeepSeekRequest.Message> messages = new ArrayList<>();
        messages.add(new DeepSeekRequest.Message("user", userMessage));

        // 构建请求体
        DeepSeekRequest request = new DeepSeekRequest();
        request.setMessages(messages);

        // 创建 HTTP 实体
        HttpEntity<DeepSeekRequest> entity = new HttpEntity<>(request, headers);

        try {
            // 发送请求
            ResponseEntity<DeepSeekResponse> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    DeepSeekResponse.class
            );

            // 处理响应
            if (response.getStatusCode() == HttpStatus.OK &&
                    response.getBody() != null &&
                    !response.getBody().getChoices().isEmpty()) {

                return response.getBody().getChoices().get(0).getMessage().getContent();
            } else {
                return "API 调用失败: " + response.getStatusCode();
            }

        } catch (Exception e) {
            return "调用 DeepSeek API 时发生错误: " + e.getMessage();
        }
    }
}