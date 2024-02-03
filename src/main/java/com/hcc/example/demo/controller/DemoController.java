package com.hcc.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.hcc.example.demo.service.DemoService;
import com.hcc.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {
    @Autowired
    DemoService demoService;

//    @Value("#{demoService}")
//    private DemoService port;

    @GetMapping(value = "/test")
    @ResponseBody
    public String test(){
        User info = demoService.getInfo(1,1);
//        return JSONObject.toJSONString(info);
        return null;
    }
}
