package com.joker.ams.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gjl12
 */
@RestController
@RequestMapping("demo")
public class Demo {
    @PreAuthorize("hasAnyAuthority('demo:test')")
    @GetMapping("/hello")
    public String hello(){
        return "demo-security-hello";
    }
    //每一个接口的方法上面写死权限
}
