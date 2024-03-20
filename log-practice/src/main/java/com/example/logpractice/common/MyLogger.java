package com.example.logpractice.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL){
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("로그: ["+uuid+"] " + "[" + requestURL + "] "+message);
    }

    @PostConstruct //고객 요청이 처음 들어와 초기화
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope bean create : "+this);
    }

    @PreDestroy //고객 요청이 빠져나갈 때
    public void close() {
        System.out.println("["+uuid+"] request scope bean close : "+this);
    }
}
