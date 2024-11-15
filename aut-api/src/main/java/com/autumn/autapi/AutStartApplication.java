package com.autumn.autapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.autumn.autuser.mapper")
public class AutStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutStartApplication.class, args);
        System.out.println(
                        "=================================================================================\n" +
                        "  ___                  _         _                           _                __ \n" +
                        " / _ \\ _ __   ___     / \\  _   _| |_ _   _ _ __ ___  _ __   | |    ___  __ _ / _|\n" +
                        "| | | | '_ \\ / _ \\   / _ \\| | | | __| | | | '_ ` _ \\| '_ \\  | |   / _ \\/ _` | |_ \n" +
                        "| |_| | | | |  __/  / ___ \\ |_| | |_| |_| | | | | | | | | | | |__|  __/ (_| |  _|\n" +
                        " \\___/|_| |_|\\___| /_/   \\_\\__,_|\\__|\\__,_|_| |_| |_|_| |_| |_____\\___|\\__,_|_|  \n" +
                        "                                                                                 \n" +
                        "=================================================================================\n" +
                        "\n" +
                        "                                                                           V0.0.1\n" +
                        "===> 启动成功"
        );
    }

}
