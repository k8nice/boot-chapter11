package com.nice.controller;

import com.nice.enumeration.SexEnum;
import com.nice.pojo.User;
import com.nice.service.JdbcTmplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    private JdbcTmplUserService jdbcTmplUserService;

    @RequestMapping("/insert")
    public String insert(){
        User user = new User();
        user.setUserName("nice");
        user.setSex(SexEnum.getEnumById(1));
        user.setNote("感觉不会再爱了");
        Integer result = jdbcTmplUserService.insertUser(user);
        return result.toString();
    }

}
