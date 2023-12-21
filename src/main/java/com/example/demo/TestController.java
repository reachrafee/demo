package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private StudentService studentService;
    @GetMapping(value = "/test")
    public String test(@RequestBody ClientDTO client) {

        System.out.println("client1: " +Client.valueOf("CLIENT1").createServiceInstance().test());
        System.out.println("client2: " +Client.valueOf("CLIENT2").createServiceInstance().test());
        System.out.println("client: " +client);
        System.out.println(Client.valueOf(client.getClient()).createServiceInstance().test());
studentService.saveStudent(new Student("test"));
        //return Client.valueOf(client.getClient()).createServiceInstance().test();
        return studentService.getStudentById(153).getName();
    }
}
