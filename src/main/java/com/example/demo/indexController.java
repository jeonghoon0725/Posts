package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class indexController {

    //처음 시작, 404
    @GetMapping("/")
    public String index(HttpServletRequest request) {
        String session = request.getSession().getId();

//        if(session != null) {
//            return "redirect:/"+"pages/blog";
//        }

        return "login";
    }
}
