package com.example.demo.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@RestController
public class UserController {
    String DEFAULT_PATH = "pages";

    @RequestMapping(value = "sign-in.do", method = RequestMethod.POST)
    public ModelAndView signIn(ModelAndView mav, HttpServletRequest request) {

        //추후에 db에서 검증으로 변경
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("root") && password.equals("1234")) {
            mav.setViewName(DEFAULT_PATH+"/"+"blog");
        } else {
            mav.setViewName("login");
        }

        return mav;
    }

    @RequestMapping(value = "sign-up.do", method = RequestMethod.POST)
    public ModelAndView signUp(ModelAndView mav, HttpServletRequest request) {

        mav.addObject("CRUD", "C");
        mav.setViewName(DEFAULT_PATH+"/"+"userInfo");

        return mav;
    }

    @RequestMapping(value = "getUserInfo.do", method = RequestMethod.POST)
    public ModelAndView getUserInfo(ModelAndView mav, HttpServletRequest request) {

        //request에서 가져온 user id로 세부 정보 조회

        mav.addObject("CRUD", "U");
        mav.setViewName(DEFAULT_PATH+"/"+"userInfo");

        return mav;
    }
}
