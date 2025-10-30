package com.example;

import com.example.service.DeepSeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan("com.example.service")
public class ProApiApplication {

    @Autowired
    private static ApplicationContext context;

    @Autowired
    private static DeepSeekService deepSeekService;

    public static void main(String[] args) {
        context = SpringApplication.run(ProApiApplication.class, args);
        deepSeekService = context.getBean(DeepSeekService.class);
        DeepSeek();
    }

    public static void DeepSeek(){
        Scanner input = new Scanner(System.in,"GBK");
        boolean flag = true;
        while(flag){
            System.out.println("请输入问题(exit退出回答):");
            String msg = input.nextLine();
            if (!msg.equals("exit")){
                System.out.println("========================================");
                System.out.println("思考中...");
                String content = deepSeekService.chat(msg);
                System.out.println("DeepSeek answer :>\n" + content);
                System.out.println("========================================");
            }else{
                flag = false;
            }
        }
        System.out.println("对话结束...");
    }
}

/*
@SpringBootApplication
public class ProApiApplication implements CommandLineRunner {

    @Autowired
    private DeepSeekService deepSeekService;

    public static void main(String[] args) {
        SpringApplication.run(ProApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        startChat();
    }

    private void startChat() {
        Scanner input = new Scanner(System.in);

        System.out.println("🚀 DeepSeek 对话系统已启动!");
        System.out.println("💡 输入 'exit' 退出程序");

        while(true) {
            System.out.print("\n❓ 请输入你的问题: ");
            String msg = input.nextLine().trim();

            if ("exit".equalsIgnoreCase(msg)) {
                System.out.println("👋 再见！");
                break;
            }

            if (msg.isEmpty()) {
                System.out.println("⚠️ 问题不能为空");
                continue;
            }

            try {
                System.out.println("🔄 思考中...");
                String content = deepSeekService.chat(msg);
                System.out.println("\n🤖 DeepSeek 回答:");
                System.out.println("========================================");
                System.out.println(content);
                System.out.println("========================================");
            } catch (Exception e) {
                System.err.println("❌ 调用失败: " + e.getMessage());
            }
        }
        input.close();
    }
}*/
