package com.example;

import com.example.service.DeepSeekService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class ProApiApplicationTests {

    /*@Autowired
    private DeepSeekService deepSeekService;

    @Test
    void ds_api() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("请输入问题(exit退出回答)：\n");
            String msg = input.nextLine();
            if (!msg.equals("exit")){
                String content = deepSeekService.chat(msg);
                System.out.println("DeepSeek answer :>\n" + content);
            }

        }

    }*/

}
