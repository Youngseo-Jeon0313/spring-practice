package com.example.logpractice.service;


import com.example.logpractice.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final MyLogger myLogger;
    public void logic(String id){
        myLogger.log("service id = "+id);
    }
}
