package com.example.jdbctemplate;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {
    public void execute(Callback callback){
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 위임
        callback.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

    }
}
