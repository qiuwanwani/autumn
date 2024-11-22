package com.autumn.autapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.autumn.**")
public class AutApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutApiApplication.class, args);
        System.out.println(
                """
                     _         _\s
                    / \\  _   _| |_ _   _ _ __ ___  _ __\s
                   / _ \\| | | | __| | | |  _   _ \\|  _ \\\s
                  / ___ \\ |_| | |_| |_| | | | | | | | | |\s
                 /_/   \\_\\__,_|\\__|\\__,_|_| |_| |_|_| |_|\s
                \s
                ===> 启动成功 (V0.0.1)"""
        );
    }

}
