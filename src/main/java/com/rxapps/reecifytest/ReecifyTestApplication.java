package com.rxapps.reecifytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class ReecifyTestApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(ReecifyTestApplication.class, args);
        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }

}
