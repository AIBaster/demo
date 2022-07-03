package com.example.demo;

import com.example.demo.command.SimpleCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {

        SpringApplication.run(Demo2Application.class, args);

//        var s1 = "aaaabbbbb".getBytes(StandardCharsets.UTF_8);
//        var s2 = new String("aaaabbbbb").getBytes(StandardCharsets.UTF_8);
//        var c1 = new SimpleCommand("aaaasdgf12345678901234567890123sdfgbbbbb");
//        var c2 = new SimpleCommand("aaaati12345678901234567890123yokjjkbbbbb");
//
//        System.out.println(c1.hashCode() == c2.hashCode());
//        System.out.println(c1);
//        System.out.println(c2);

    }

}
