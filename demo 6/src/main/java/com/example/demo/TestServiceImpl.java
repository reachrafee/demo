package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("testServiceImpl")
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "Hello World";
    }
}
