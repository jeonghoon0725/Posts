package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 404 Not Found 에러 처리
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404Error(NoHandlerFoundException ex, Model model) {
        System.out.println("404");
        System.out.println(ex.getMessage());

        //model.addAttribute("error", "404 - Page Not Found");
        //model.addAttribute("message", "The page you are looking for does not exist.");

        return "redirect:/user/sign-in";
    }

    // 다른 예외 처리 (Optional)
    @ExceptionHandler(Exception.class)
    public String handleGeneralError(Exception ex, Model model) {
        System.out.println("handleGeneralError");
        System.out.println(ex.getMessage());

        model.addAttribute("error", "Unexpected Error");
        model.addAttribute("message", ex.getMessage());
        return "system/default"; // 기본 에러 페이지로 이동
    }
}
