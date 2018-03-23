package edu.wyu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 *
 *
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/list.do")
    public String list(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {

        return "/haha";
    }
}
