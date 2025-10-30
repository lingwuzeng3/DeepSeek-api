package com.example.pojo;

/**
 * 包名：com.example.pojo
 * 用户：admin
 * 日期：2025-10-30
 * 项目名称：Pro-api
 */
import lombok.Data;
import java.util.List;

@Data
public class DeepSeekRequest {
    private String model = "deepseek-chat";
    private List<Message> messages;
    private boolean stream = false;
    private Double temperature = 0.7;
    private Integer max_tokens = 2048;

    @Data
    public static class Message {
        private String role;
        private String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}
