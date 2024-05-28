package com.example.filter.controller;

import com.example.filter.interceptor.OpenApi;
import com.example.filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @OpenApi
    @PostMapping("")
    public UserRequest register(
            @RequestBody
            UserRequest userRequest
    ){
        log.info("{}", userRequest);
        return userRequest;
    }

    //여기에는 @OpenApi 어노테이션이 없으므로
    //이 핸들러가 동작하면 No Content 가 return 된다.
    @GetMapping("/hello")
    public String hello(){
        log.info("hello");
        return "hello";
    }
}
