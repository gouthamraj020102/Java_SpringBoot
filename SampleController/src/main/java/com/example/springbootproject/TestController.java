package com.example.springbootproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class TestController {

    @RequestMapping("/test")
    public String testing() {
        return "Just for testing purpose !!";
    }
}
