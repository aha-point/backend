package com.ahaPoint.member.interfaces.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class MemberController {

    //@GetMapping("/member")
    @ResponseBody
    public String testGet() {
        return "jiaTest";
    }

}
