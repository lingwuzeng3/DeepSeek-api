package com.example.pojo;

import lombok.Data;

import java.util.List;

/**
 * 包名：com.example.pojo
 * 用户：admin
 * 日期：2025-10-30
 * 项目名称：Pro-api
 */

@Data
public class DeepSeekResponse {
    private String id;
    private String object;
    private Long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;

    @Data
    public static class Choice {
        private Integer index;
        private Message message;
        private String finish_reason;
    }

    @Data
    public static class Message {
        private String role;
        private String content;
    }

    @Data
    public static class Usage {
        private Integer prompt_tokens;
        private Integer completion_tokens;
        private Integer total_tokens;
    }
}