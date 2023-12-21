package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("testServiceImpl1")
public class TestServiceImpl1 implements TestService{
    @Override
    public String test() {
        return "Hello World 1";
    }
}
